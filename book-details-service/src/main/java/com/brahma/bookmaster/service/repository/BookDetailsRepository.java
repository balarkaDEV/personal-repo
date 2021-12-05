package com.brahma.bookmaster.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brahma.bookmaster.service.model.BookMaster;

@Repository
public interface BookDetailsRepository extends JpaRepository<BookMaster, Long> {
	@Query(value = "SELECT * FROM book_master f WHERE f.title = ?1", nativeQuery = true)
	public BookMaster findBookByTitle(String title);
	
	@Query(value = "SELECT * FROM book_master f WHERE f.author = ?1", nativeQuery = true)
	public BookMaster findBookByAuthor(String author);
	
	@Query(value = "SELECT * FROM book_master f WHERE f.title = ?1 AND f.author=?2", nativeQuery = true)
	public BookMaster findBookByTitleAndAuthor(String title, String author);
}
