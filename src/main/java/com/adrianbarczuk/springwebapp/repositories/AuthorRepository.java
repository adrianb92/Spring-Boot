package com.adrianbarczuk.springwebapp.repositories;

import com.adrianbarczuk.springwebapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {


}
