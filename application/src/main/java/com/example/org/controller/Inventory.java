package com.example.org.controller;


import com.example.org.api.NewBookRequest;
import com.example.org.model.book.Book;
import com.example.org.model.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Inventory {


    @Autowired
    BookRepository repository;

    @PostMapping(path = "/book")
    public Book addBook(@RequestBody NewBookRequest request) {


        return repository.save(Book.builder()
                        .author(request.getAuthors())
                        .publisher(request.getPublisher())
                        .price(request.getPrice())
                        .title(request.getTitle())
                .build());

    }
}
