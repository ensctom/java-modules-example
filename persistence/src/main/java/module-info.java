module persistence {
    requires java.persistence;
    requires java.sql;

    requires java.xml.bind;
    requires net.bytebuddy;

    requires spring.orm;
    requires spring.data.commons;
    requires spring.data.jpa;
    requires spring.boot.starter.data.jpa;
    requires spring.context;
    requires static lombok;
    requires spring.jdbc;
    requires spring.tx;


    // required to work with spring reflection
    opens com.example.org.persistence.entity to org.hibernate.orm.core, spring.core;
    opens com.example.org.persistence.config to spring.core, spring.beans, spring.context;

    exports com.example.org.persistence.entity;
    exports com.example.org.persistence.repository;
}