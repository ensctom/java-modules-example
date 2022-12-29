module persistence {
    requires java.persistence;
    requires spring.data.commons;
    requires spring.boot.starter.data.jpa;
    requires spring.context;
    requires static lombok;
    exports com.example.org.model.book;
}