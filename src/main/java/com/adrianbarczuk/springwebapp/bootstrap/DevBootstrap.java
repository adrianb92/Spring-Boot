package com.adrianbarczuk.springwebapp.bootstrap;

import com.adrianbarczuk.springwebapp.model.Author;
import com.adrianbarczuk.springwebapp.model.Book;
import com.adrianbarczuk.springwebapp.repositories.AuthorRepository;
import com.adrianbarczuk.springwebapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        setData();
    }

    private void setData() {

        Author mickiewicz = new Author("Adam", "Mickiewicz");
        Book panTadeusz = new Book("Pan Tadeusz", "978-83-8008-125-3", "Media Rodzina");
        mickiewicz.getBooks().add(panTadeusz);
        panTadeusz.getAuthors().add(mickiewicz);

        authorRepository.save(mickiewicz);
        bookRepository.save(panTadeusz);


        Author sienkiewicz = new Author("Henryk", "Sienkiewicz");
        Book quoVadis = new Book("Quo vadis", "978-83-7887-641-0", "Dragon");
        sienkiewicz.getBooks().add(quoVadis);
        quoVadis.getAuthors().add(sienkiewicz);

        authorRepository.save(sienkiewicz);
        bookRepository.save(quoVadis);

    }

}
