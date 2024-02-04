package com.java.springboot.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.java.springboot.swagger.model.Book;
import com.java.springboot.swagger.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

//springdoc.api-docs.path=/book-docs --in application.properties
//http://localhost:8089/book-docs -> for swagger console
//http://localhost:8089/book-docs.yaml --will download .yaml file
//http://localhost:8089/swagger-ui/index.html --> list of all endpoints defined in controller 
//and there we can test as well

@RestController
@RequestMapping("/book/api/")
public class BookController {

	@Autowired
	private BookService bookService;

	@PostMapping("add")
	public String saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}

	@Operation(summary = "Gets book by ID", description = "book must exist")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Ok"),
			@ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
			@ApiResponse(responseCode = "404", description = "book not found"),
			@ApiResponse(responseCode = "500", description = "Internal server error") })
	@GetMapping("get/{id}")
	public Book getBookById(@PathVariable int id) {
		return bookService.getBookById(id);
	}

	@GetMapping("get/all")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@PutMapping("update/{id}/{name}")
	public String updateBook(@PathVariable int id, @PathVariable String name) {
		return bookService.updateBook(id, name);
	}

	@DeleteMapping("delete/{id}")
	public String deleteBook(@PathVariable int id) {
		return bookService.deleteBook(id);
	}
}
