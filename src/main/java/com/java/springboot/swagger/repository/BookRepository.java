package com.java.springboot.swagger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.java.springboot.swagger.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
