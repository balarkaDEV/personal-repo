package com.brahma.bookmaster.service.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brahma.bookmaster.service.model.BookMaster;
import com.brahma.bookmaster.service.repository.BookDetailsRepository;

@Service
public class BookDetailsBusiness {

	@Autowired
	private BookDetailsRepository bookDetailsRepository;
	
	public BookMaster saveBookMaster(BookMaster bookMaster){
		return bookDetailsRepository.save(bookMaster);
	}
	
	public BookMaster getBookByTitle(String title) {
		return bookDetailsRepository.findBookByTitle(title);
	}
	
	public BookMaster getBookByTitleAndOrAuthor(String title, String author) {
		if(title != null && author != null)
			return bookDetailsRepository.findBookByTitleAndAuthor(title, author);
		else if(title != null)
			return bookDetailsRepository.findBookByTitle(title);
		else if(author != null)
			return bookDetailsRepository.findBookByAuthor(author);
		
		return null;
	}
	
	public Optional<BookMaster> getBookByID(long id) {
		return bookDetailsRepository.findById(id);
	}
	
	public List<BookMaster> getAll(){
		return bookDetailsRepository.findAll();
	}
}
