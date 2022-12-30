module application {

    requires persistence;
    requires common;

    requires spring.web;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.beans;

    opens com.example.org.controller to spring.core, spring.beans, spring.web;
    opens com.example.org to spring.core, spring.beans, spring.context;
}