package com.example.org.api;

import lombok.Data;

import java.util.Date;

@Data
public class NewBookRequest {

    private String[] authors;
    private String title;
    private String[] publisher;
    private Integer price;
    Date publication;
}
