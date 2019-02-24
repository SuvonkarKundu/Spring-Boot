package com.crud.Services;

import com.crud.Repository.AuthorRepository;
import com.crud.Repository.BookRepository;
import com.crud.model.Author;
import com.crud.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Suvonkar Kundu on 2/23/2019.
 */
@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public ArrayList<Book> getAllListbook() {
        ArrayList<Book> listbooks = new ArrayList<>();
        bookRepository.findAll().forEach(listbooks::add);
        return listbooks;
    }

    public Book addListbook(Book book) {
        return bookRepository.save(book);
    }

    public Book getById(long id) {
        return bookRepository.findById(id);
    }

    public Book deletById(long id) {
        return bookRepository.deleteById(id);
    }

}
