package com.brahma.bookmaster.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.brahma.bookmaster.service.business.BookDetailsBusiness;
import com.brahma.bookmaster.service.model.BookMaster;

@RestController
@RequestMapping(value="${base-url}")
public class BookDetailsController {

	@Autowired
	private BookDetailsBusiness bookDetailsBusiness;
	
	@PostMapping(value="/save")
	public BookMaster saveBookMaster(@RequestBody final BookMaster bookMasterList){
		return bookDetailsBusiness.saveBookMaster(bookMasterList);
	}
	
	@GetMapping(value="/{id}")
	public Optional<BookMaster> getBookByID(@PathVariable long id) {
		return bookDetailsBusiness.getBookByID(id);
	}
	
	@GetMapping(value="/")
	public BookMaster getBookByTitleAndOrAuthor(@RequestParam String title, String author) {
		return bookDetailsBusiness.getBookByTitleAndOrAuthor(title,author);
	}
	
	@GetMapping(value="/all")
	public List<BookMaster> getAllBooks(){
		return bookDetailsBusiness.getAll();
	}
}
