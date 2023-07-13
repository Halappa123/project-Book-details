package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Book;
import com.example.service.BookService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/saveAll")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "success"),
			@ApiResponse(code = 400,message = "Error"),
			@ApiResponse(code = 500,message = "Inavlid input")
			})
	//@PreAuthorize("hasAuthority('ADMIN')")
	public ResponseEntity<Book> saveAllBookDetails(@RequestBody List<Book> book){
		return new ResponseEntity(bookService.saveAllBookDetails(book),HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Success"),
			@ApiResponse(code = 400,message = "Error"),
			@ApiResponse(code = 500,message = "Invalid Input")
	})
	@GetMapping("/getAll")
	//@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Book> getAllBookDetails(){
		return new ResponseEntity(bookService.getAllBookDetails(),HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/get{id}")
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Success"),
			@ApiResponse(code = 400,message = "Error"),
			@ApiResponse(code = 500,message = "Invalid Input")
	})
	public ResponseEntity<Book> getAllBookDetailsById(@PathVariable String id){
		return new ResponseEntity(bookService.getBookdetailsById(id),HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Success"),
			@ApiResponse(code = 400,message = "Error"),
			@ApiResponse(code = 500,message = "Invalid Input")
	})
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Book> deleteBookById(@RequestParam String id){
		return new ResponseEntity(bookService.deleteBookDetailsById(id),HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "SuccessFully Delete"),
			@ApiResponse(code = 400,message = "Error While Deleting "),
			@ApiResponse(code = 500,message = "Invalid Input")
	})
	@DeleteMapping("/delete/all")
	public ResponseEntity<Book> deleteAllBookDetails(@RequestBody List<Book> book){
		return new ResponseEntity(bookService.deleteAllBookDetails(book),HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Success"),
			@ApiResponse(code = 400,message = "Error"),
			@ApiResponse(code = 500,message = "Invalid Input")
	})
	@PutMapping("/update/{id}")
	public ResponseEntity<Book> updateAllBookDetailsById(@PathVariable ("id") String id,@RequestBody Book books){
		return new ResponseEntity(bookService.updateAllBookDetailsById(id, books),HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Success"),
			@ApiResponse(code = 400,message = "Error"),
			@ApiResponse(code = 500,message = "Invalid Input")
	})
	@GetMapping("/get/by/price")
	public ResponseEntity<Book> getBookByPrice(){
		return new ResponseEntity(bookService.getBookByPrice(),HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Success"),
			@ApiResponse(code = 400,message = "Error"),
			@ApiResponse(code = 500,message = "Invalid Input")
	})
	@GetMapping("/get/by/{author}")
	public ResponseEntity<Book> getBookByAuthor(@RequestParam String author){
		return new ResponseEntity(bookService.getBookByAuthor(author),HttpStatus.OK);
	}


	
	
	
	

}
