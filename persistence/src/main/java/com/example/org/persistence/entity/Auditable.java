package com.example.org.persistence.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

@MappedSuperclass
public class Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @CreatedDate
    Date createdAt;

    @LastModifiedDate
    Date modifyAt;
}
