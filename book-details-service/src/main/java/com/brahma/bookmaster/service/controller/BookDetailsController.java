package com.brahma.bookmaster.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping(value="${service.baseuri}")
public class BookDetailsController {

	@Autowired
	private BookDetailsBusiness bookDetailsBusiness;
	
	@PostMapping(value="/save")
	public ResponseEntity<BookMaster> saveBookMaster(@RequestBody final BookMaster bookMasterList){
		BookMaster response = bookDetailsBusiness.saveBookMaster(bookMasterList);
		return new ResponseEntity<BookMaster>(response, HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public Optional<BookMaster> getBookByID(@PathVariable long id) {
		return bookDetailsBusiness.getBookByID(id);
	}
	
	@GetMapping(value="/")
	public ResponseEntity<BookMaster> getBookByTitleAndOrAuthor(@RequestParam String title, String author) {
		BookMaster response = bookDetailsBusiness.getBookByTitleAndOrAuthor(title,author);
		return new ResponseEntity<BookMaster>(response, HttpStatus.OK);
	}
	
	@GetMapping(value="/all")
	public ResponseEntity<List<BookMaster>> getAllBooks(){
		List<BookMaster> list = bookDetailsBusiness.getAll();
		return new ResponseEntity<List<BookMaster>>(list, HttpStatus.OK);
	}
}
