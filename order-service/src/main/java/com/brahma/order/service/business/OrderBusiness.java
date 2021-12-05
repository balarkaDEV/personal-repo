package com.brahma.order.service.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.brahma.order.service.model.BookMaster;
import com.brahma.order.service.model.OrderDetails;
import com.brahma.order.service.model.OrderMaster;
import com.brahma.order.service.model.OrderRequest;
import com.brahma.order.service.model.OrderResponse;
import com.brahma.order.service.repository.OrderDetailsRepository;
import com.brahma.order.service.repository.OrderMasterRepository;
import com.brahma.order.service.util.OrderStatus;

@Service
public class OrderBusiness {

	//private final String BOOK_SERVICE_FIND_ID_URL = "${book-service-find-by-id}";
	//private final String BOOK_SERVICE_SAVE = "${book-service-save}";
	
	@Autowired
	private OrderMasterRepository orderMasterRepository;
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	@Autowired
	private WebClient.Builder webClientBuilder;
	
	public OrderResponse saveOrder(List<OrderRequest> orderRequest) {
		OrderResponse response = new OrderResponse();
		
		double totalPrice = 0.0;
		double taxAmount = 20;
		
		List<OrderDetails> orderDetailsList = new ArrayList<>();
		Map<String, List<BookMaster>> bookMasterMap = getBookMasterMap(orderRequest);
		
		for (Map.Entry<String, List<BookMaster>> entry : bookMasterMap.entrySet()) {
			List<BookMaster> bookMasterList = entry.getValue();
			BookMaster bookMaster = bookMasterList.get(0);
			
			double listPrice = bookMaster.getListPrice();
			int discount = bookMaster.getDiscount();
			
			double discountAmt = 0;
			
			if(discount != 0)
				discountAmt = listPrice * (discount/100);
			
			double priceAfterDisct = listPrice - discountAmt;
			totalPrice = totalPrice + priceAfterDisct;
			
			OrderDetails orderDetails = new OrderDetails();
			orderDetails.setTitle(bookMaster.getTitle());
			orderDetails.setAuthor(bookMaster.getAuthor());
			orderDetails.setPrice(totalPrice);
			orderDetails.setDiscount(discountAmt);
			orderDetails.setTax(taxAmount);
			orderDetails.setOrderDate(new Date());
			orderDetailsList.add(orderDetails);
			
			int noOfCopies = bookMasterList.size();
			int stock = bookMaster.getStock();
			bookMaster.setStock(stock - noOfCopies);
			updateBookMaster(bookMaster);
		}
		
		OrderMaster orderMaster = new OrderMaster();
		orderMaster.setAmount(totalPrice);
		orderMaster.setNoOfBooks(orderRequest.size());
		orderMaster.setStatus(OrderStatus.RECEIVED.getValue());
		orderMaster.setOrderDate(new Date());
		orderMaster = orderMasterRepository.save(orderMaster);
		
		response.setId(orderMaster.getId());
		response.setStatus(OrderStatus.RECEIVED.getValue());
		response.setAmount(totalPrice);
		response.setNoOfBooks(orderRequest.size());
		response.setOrderDate(orderMaster.getOrderDate());
		response.setOrderDetailsList(saveOrderDetails(orderMaster.getId(), orderDetailsList));
		
		return response;
	}
	
	private List<OrderDetails> saveOrderDetails(long orderMasterId, List<OrderDetails> orderDetailsList) {
		List<OrderDetails> orderDetailsRet = new ArrayList<>();
		for(OrderDetails eachDetails : orderDetailsList) {
			eachDetails.setOrderId(orderMasterId);
			orderDetailsRet.add(orderDetailsRepository.save(eachDetails));
		}
		return orderDetailsRet;
	}
	
	public OrderResponse findOrderById(long id) {
		Optional<OrderMaster> orderMaster = orderMasterRepository.findById(id);
		List<OrderDetails> orderDetails = orderDetailsRepository.findOrderDetailsByOrderId(id);
		
		OrderResponse response = new OrderResponse();
		response.setId(orderMaster.get().getId());
		response.setAmount(orderMaster.get().getAmount());
		response.setNoOfBooks(orderMaster.get().getNoOfBooks());
		response.setOrderDate(orderMaster.get().getOrderDate());
		response.setOrderDetailsList(orderDetails);
		return response;
	}
	
	private Map<String, List<BookMaster>> getBookMasterMap(List<OrderRequest> orderRequest){
		Map<String, List<BookMaster>> bookMasterMap = new HashMap<>();
		List<BookMaster> bookMasterList = null;
		for(OrderRequest eachOrder : orderRequest) {
			BookMaster bookMaster = getBookMaster(eachOrder.getBookId());
			if(bookMasterMap.get(bookMaster.getTitle()) == null) {
				bookMasterList = new ArrayList<>();
				bookMasterList.add(bookMaster);
				bookMasterMap.put(bookMaster.getTitle(), bookMasterList);
			} else {
				bookMasterMap.get(bookMaster.getTitle()).add(bookMaster);
			}
		}
		return bookMasterMap;
	}
	
	private BookMaster getBookMaster(long id) {
		return webClientBuilder.build()
				.get()
					.uri("http://localhost:8010/service/book/{id}",id)
						.retrieve()
							.bodyToMono(BookMaster.class)
								.block();
	}
	
	private BookMaster updateBookMaster(BookMaster bookMaster) {
		return webClientBuilder.build()
				.post()
					.uri("http://localhost:8010/service/book/save")
						.contentType(MediaType.APPLICATION_JSON)
							.accept(MediaType.APPLICATION_JSON)
								.body(BodyInserters.fromValue(bookMaster))
									.retrieve()
										.bodyToMono(BookMaster.class)
											.block();
	}
}
