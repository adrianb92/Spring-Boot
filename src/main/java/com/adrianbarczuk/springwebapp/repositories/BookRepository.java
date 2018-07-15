package com.adrianbarczuk.springwebapp.repositories;

import com.adrianbarczuk.springwebapp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
