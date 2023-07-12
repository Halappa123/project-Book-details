//package com.example.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.dto.Book;
//import com.example.service.BookService;
//
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//
//@RestController
//@RequestMapping("/api1")
//public class PoertyBooks {
//	
//	@Autowired
//	private BookService bookService;
//	
//	@SuppressWarnings("unchecked")
//	@PostMapping("/saveAll")
//	@ApiResponses(value = {
//			@ApiResponse(code = 200,message = "success"),
//			@ApiResponse(code = 400,message = "Error"),
//			@ApiResponse(code = 500,message = "Inavlid input")
//			})
//	//@PreAuthorize("hasAuthority('ADMIN')")
//	public ResponseEntity<Book> saveAllBookDetails(@RequestBody List<Book> book){
//		return new ResponseEntity(bookService.saveAllBookDetails(book),HttpStatus.OK);
//	}
//	
//
//}
