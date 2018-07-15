package com.adrianbarczuk.springwebapp.repositories;

import com.adrianbarczuk.springwebapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
