package com.example.service;

import java.util.List;

import org.springframework.util.MultiValueMap;

import com.example.dto.Book;
import com.example.dto.ResultEntity;

public interface BookService {

	ResultEntity saveAllBookDetails(List<Book> book);

	ResultEntity getAllBookDetails();

	ResultEntity getBookdetailsById(String id);

	ResultEntity deleteBookDetailsById(String id);

	ResultEntity deleteAllBookDetails(List<Book> book);

	//ResultEntity updateAllBookDetailsById(String id,Book books);

	ResultEntity updateAllBookDetailsById(String id,Book books);

	ResultEntity getBookByPrice();

	ResultEntity getBookByAuthor(String author);

}
