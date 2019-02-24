package com.crud.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

/**
 * Created by Suvonkar Kundu on 2/23/2019.
 */
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Expose
    long id;
    @Column(name = "title")
    @Expose
    String title;
    @Column(name = "language")
    @Expose
    String language;
    @Column(name = "publisher")
    @Expose
    String publisher;
    @ManyToOne
    @Expose
    Author author;

    public Book(String title, String language, String publisher, Author author) {
        this.title = title;
        this.language = language;
        this.publisher = publisher;
        this.author = author;
    }

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
