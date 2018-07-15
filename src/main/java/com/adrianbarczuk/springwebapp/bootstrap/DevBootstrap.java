package com.adrianbarczuk.springwebapp.bootstrap;

import com.adrianbarczuk.springwebapp.model.Author;
import com.adrianbarczuk.springwebapp.model.Book;
import com.adrianbarczuk.springwebapp.model.Publisher;
import com.adrianbarczuk.springwebapp.repositories.AuthorRepository;
import com.adrianbarczuk.springwebapp.repositories.BookRepository;
import com.adrianbarczuk.springwebapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        setData();
    }

    private void setData() {

        Author mickiewicz = new Author("Adam", "Mickiewicz");
        Publisher mediaRodzina = new Publisher("Media Rodzina", "adres 1");
        Book panTadeusz = new Book("Pan Tadeusz", "978-83-8008-125-3", mediaRodzina);
        mickiewicz.getBooks().add(panTadeusz);
        panTadeusz.getAuthors().add(mickiewicz);

        authorRepository.save(mickiewicz);
        publisherRepository.save(mediaRodzina);
        bookRepository.save(panTadeusz);


        Author sienkiewicz = new Author("Henryk", "Sienkiewicz");
        Publisher dragon = new Publisher("Dragon", "adres 2");
        Book quoVadis = new Book("Quo vadis", "978-83-7887-641-0", dragon);
        sienkiewicz.getBooks().add(quoVadis);
        quoVadis.getAuthors().add(sienkiewicz);

        authorRepository.save(sienkiewicz);
        publisherRepository.save(dragon);
        bookRepository.save(quoVadis);

    }

}
