package com.example.org.controller;


import com.example.org.api.NewBookRequest;
import com.example.org.persistence.entity.Book;
import com.example.org.persistence.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping(path = "/book")
    public List<Book> getBooks() {
        List<Book> list = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}
