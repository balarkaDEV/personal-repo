package com.brahma.order.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brahma.order.service.model.OrderDetails;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
	
	@Query(value = "SELECT * FROM order_details f WHERE f.order_id = ?1", nativeQuery = true)
	public List<OrderDetails> findOrderDetailsByOrderId(long orderId);
}
