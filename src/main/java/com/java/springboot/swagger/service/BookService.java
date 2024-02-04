package com.java.springboot.swagger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.springboot.swagger.model.Book;
import com.java.springboot.swagger.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepo;

	public String saveBook(Book book) {
		bookRepo.save(book);
		return "Book Saved Sucessfully!" + book.getId();
	}

	public Book getBookById(int id) {
		return bookRepo.findById(id).get();
	}

	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}

	public String updateBook(int id, String name) {
		Book book = Book.builder().id(id).bookName(name).build();
		bookRepo.save(book);
		return "Book updated Sucessfully!" + book.getId();
	}

	public String deleteBook(int id) {
		Book book = Book.builder().id(id).build();
		bookRepo.delete(book);
		return "Book deleted Sucessfully!" + book.getId();
	}
}
