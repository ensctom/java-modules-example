package com.example.org.model.book;

import com.example.org.model.Auditable;
import lombok.Builder;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Builder
public class Book extends Auditable {

    String[] author;

    String title;

    Date publication;

    String[] publisher;

    Integer price;
}
