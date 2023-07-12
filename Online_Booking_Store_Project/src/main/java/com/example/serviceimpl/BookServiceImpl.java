package com.example.serviceimpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.Book;
import com.example.dto.ResultEntity;
import com.example.repository.BookRepository;
import com.example.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public ResultEntity saveAllBookDetails(List<Book> book) {

		List<Book> saveall=bookRepository.saveAll(book);
		return new ResultEntity("All Book Details Saved Successfully", saveall);
		
		
	}

	@SuppressWarnings({ "unused", "finally" })
	@Override
	public ResultEntity getAllBookDetails() {
		List<Book> book2 = bookRepository.findAll();
		if (!book2.isEmpty() || book2 != null) {
			return new ResultEntity("All Book Details Fetched Successfully", book2);
		} else {
			try {
				if (!book2.isEmpty() || book2 != null) {
					return new ResultEntity("All Book Details Fetched Successfully", book2);
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				return new ResultEntity("Not Fetched  Book Details", book2);
			}
		}

	}

	@Override
	public ResultEntity getBookdetailsById(String id) {
		Optional<Book> book3 = bookRepository.findById(id);

		if (book3.isPresent()) {
			Book existId = book3.get();
		}

		if (book3 != null && !book3.isEmpty()) {
			return new ResultEntity("All Book Details Fetched ", book3);
		} else {
			return new ResultEntity("Book Not Found With Given Id", book3);
		}

	}

//	@Override
//	public ResultEntity deleteBookDetailsById(String id) {
//	    Optional<Book> filteredBooks = bookRepository.findById(id);
//
//	    if (!filteredBooks.isEmpty()) {
//	        
//	        bookRepository.deleteById(id);
//	    
//	        return new ResultEntity("Books deleted successfully",filteredBooks);
//	    } else 
//	    {
//	       
//	        return new ResultEntity("No books found or no books with primary property",filteredBooks);
//	    }
//	}

	@SuppressWarnings("unused")
	public ResultEntity deleteBookDetailsById(String id) {
		List<Book> filteredBooks = bookRepository.findById(id).stream()
				.filter(book -> book.getPrice() > 0 && book.getPrice() < 10000).collect(Collectors.toList());

		if (!filteredBooks.isEmpty() || filteredBooks != null) {
			// Perform deletion of filtered books using
			// bookRepository.deleteAll(filteredBooks)
			bookRepository.deleteAll(filteredBooks);
			// Perform any additional operations or return the appropriate ResultEntity
			return new ResultEntity("Books deleted successfully", filteredBooks);
		} else {
			// Handle the case when no books with the given ID or primary property are found
			return new ResultEntity("No books found or no books with primary property", filteredBooks);
		}
	}

	@Override
	public ResultEntity deleteAllBookDetails(List<Book> books) {
		// Validation 1: Check if the list is empty
		if (books.isEmpty()) {
			return new ResultEntity("List is empty", books);
		}

		// Validation 2: Check if any book has a null or empty title
		boolean anyEmptyTitle = books.stream().anyMatch(book -> book.getTitle() == null || book.getTitle().isEmpty());
		if (anyEmptyTitle) {
			return new ResultEntity("Some books have null or empty titles", books);
		}

		// Validation 3: Check if any book has an invalid publication year
		boolean anyInvalidPrice = books.stream().anyMatch(book -> book.getAuthor() == null);
		if (anyInvalidPrice) {
			return new ResultEntity("Some books have an invalid price ", books);
		}

		// If all validations pass, perform the delete operation
		for (Book book : books) {
			bookRepository.delete(book);
		}

		// Perform any additional operations or return the appropriate ResultEntity
		return new ResultEntity("Books deleted successfully", books);
	}

	@Override
	public ResultEntity updateAllBookDetailsById(String id, Book books) {

		try {
			Book existId = bookRepository.findById(id).get();
			if (isNullOrEmpty(existId)) {
				existId.setAuthor(books.getAuthor());
				existId.setDescription(books.getDescription());
				existId.setPrice(books.getPrice());
				existId.setQuentity(books.getQuentity());
				existId.setTitle(books.getTitle());

				bookRepository.save(existId);
				return new ResultEntity("All Fields are updated Successfully", existId);

			} else if (isNullOrEmpty(existId.getAuthor())|| !isNullOrEmpty(existId)) {
				existId.setAuthor(books.getAuthor());
				bookRepository.save(existId);
				return new ResultEntity("Author Field updated Successfully", existId);
			}
			else if(isNullOrEmpty(existId.getDescription())||!isNullOrEmpty(existId)) {
				existId.setDescription(books.getDescription());
				bookRepository.save(existId);
				return new ResultEntity("Description field updated successfully", existId);
			}
		} catch (Exception e) {
			System.out.println("No Such Element found Exception");
		}
		return null;
		

	}

	private boolean isNullOrEmpty(Object object) {
		return Objects.isNull(object) || object.toString().isEmpty();
	}

	@Override
	public ResultEntity getBookByPrice()  {
		List<Book> book1=bookRepository.findAll()
		.stream()
		.filter(p->p.getPrice()>1000)
	//	.map(p->p.getPrice())
		.collect(Collectors.toList());
		
		return new ResultEntity("books fetched based on price ", book1);

}

	@Override
	public ResultEntity getBookByAuthor(String author) {

		Book existAuthor=bookRepository.findByAuthor(author).get();
		if(isNullOrEmpty(existAuthor)) {
			return new ResultEntity("Invalid Input", existAuthor);
		}
		else if(!isNullOrEmpty(existAuthor)) {
			bookRepository.save(existAuthor);
			return new ResultEntity("Data Fetched Based on author", existAuthor);
		}
		return null;
	
	}
}
