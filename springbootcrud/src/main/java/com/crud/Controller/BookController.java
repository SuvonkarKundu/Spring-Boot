package com.crud.Controller;

import com.crud.Services.AuthorService;
import com.crud.Services.BookService;
import com.crud.model.Book;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Suvonkar Kundu on 2/23/2019.
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    AuthorService authorService;
    @Autowired
    ObjectMapper mapper;
    @Autowired
    BookService bookService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public JsonNode createBook(HttpServletRequest httpRequest, @RequestBody String body) throws IOException {
        JSONObject response= new JSONObject();
        try {
            JSONObject request = new JSONObject(body);
            Book book= new Book();
            long id = Long.valueOf(request.optString("authid"));
            book.setAuthor(authorService.getById(id));
            book.setLanguage(request.getString("language"));
            book.setTitle(request.getString("title"));
            book.setPublisher(request.getString("publisher"));

            book=bookService.addListbook(book);

            if (book != null) {
                response = authorService.createResponseObject(200, "SUCCESS", new JSONObject(authorService.convertPOJOtoString(book)));
            } else {
                response = authorService.createResponseObject(200, "ERROR", new JSONObject());
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mapper.readTree(response.toString());
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public JsonNode updateBook(HttpServletRequest httpRequest, @RequestBody String body, @PathVariable("id") long id ) throws IOException {
        JSONObject response= new JSONObject();
        try {
            JSONObject request = new JSONObject(body);
            Book book= bookService.getById(id);
            if(book!=null) {
                long idauth = Long.valueOf(request.optString("authid"));
                book.setAuthor(authorService.getById(idauth));
                book.setLanguage(request.getString("language"));
                book.setTitle(request.getString("title"));
                book.setPublisher(request.getString("publisher"));

                book = bookService.addListbook(book);

                if (book != null) {
                    response = authorService.createResponseObject(200, "SUCCESS", new JSONObject(authorService.convertPOJOtoString(book)));
                } else {
                    response = authorService.createResponseObject(200, "ERROR", new JSONObject());
                }
            }
            else
            {
                return mapper.readTree(response.toString());
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mapper.readTree(response.toString());
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public JsonNode listBook( ) throws IOException, JSONException {
        JSONObject response= new JSONObject();
        ArrayList<Book> books= bookService.getAllListbook();
        if (books.size() == 0) {
            response = authorService.createResponseArray(500, "Error", new JSONArray());
        } else {
            response = authorService.createResponseArray(200, "Success", new JSONArray(authorService.convertPOJOtoString(books)));
        }
        return mapper.readTree(response.toString());
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteAuthor(HttpServletRequest httpRequest, @PathVariable("id") long id ) throws IOException, JSONException {
        JSONObject response=new JSONObject();
        bookService.deletById(id);
        return "Delete Data";
    }


}
