package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dto.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

	Optional<Book> findByAuthor(String author);

	// @Query("SELECT b FROM Book b WHERE b.author = ?1")
	//Optional<Book> findByAuthor(String author);
	// @Query("SELECT b FROM Book b WHERE b.author = ?1")
	//Optional<Book> findOne(String author);

	//Optional<Book> findByAuthor(String author);



	// Book updateAuthor(String author);


}
