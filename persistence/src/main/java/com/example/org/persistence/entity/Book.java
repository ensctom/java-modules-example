package com.example.org.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Book  extends Auditable {

    String[] author;

    String title;

    Date publication;

    String[] publisher;

    Integer price;

}
