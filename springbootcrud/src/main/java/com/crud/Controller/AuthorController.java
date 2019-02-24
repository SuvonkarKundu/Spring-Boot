package com.crud.Controller;

import com.crud.Services.AuthorService;
import com.crud.model.Author;
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
import java.util.Map;

/**
 * Created by Suvonkar Kundu on 2/23/2019.
 */
@RestController
@RequestMapping(value = "/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;
    @Autowired
    ObjectMapper mapper;



    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public JsonNode createAuthor(HttpServletRequest httpRequest, @RequestBody String body) throws IOException {
        JSONObject response= new JSONObject();
        try {
            JSONObject request = new JSONObject(body);

            Author author= new Author();
            author.setAuthorname(request.getString("authorname"));
            author.setAuthoraddress(request.getString("authoradress"));
            author.setAuthormail(request.getString("authoremail"));
            author.setAuthorphone(request.getString("authorphone"));
            author=authorService.addListAuthor(author);

            if (author != null) {
                response = authorService.createResponseObject(200, "SUCCESS", new JSONObject(authorService.convertPOJOtoString(author)));
            } else {
                response = authorService.createResponseObject(200, "ERROR", new JSONObject());
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mapper.readTree(response.toString());
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public JsonNode updateAuthor(HttpServletRequest httpRequest, @RequestBody String body, @PathVariable("id") long id ) throws IOException {
        JSONObject response= new JSONObject();
        try {
            JSONObject request = new JSONObject(body);
            Author author= authorService.getById(id);
            if(author!=null) {
                author.setAuthorname(request.getString("authorname"));
                author.setAuthoraddress(request.getString("authoradress"));
                author.setAuthormail(request.getString("authoremail"));
                author.setAuthorphone(request.getString("authorphone"));
                author=authorService.addListAuthor(author);

                if (author != null) {
                    response = authorService.createResponseObject(200, "SUCCESS", new JSONObject(authorService.convertPOJOtoString(author)));
                } else {
                    response = authorService.createResponseObject(200, "ERROR", new JSONObject());
                }


            }
            else
            {
                return  mapper.readTree(response.toString());
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  mapper.readTree(response.toString());
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public JsonNode listAuthor( ) throws IOException, JSONException {
     JSONObject response= new JSONObject();
     ArrayList<Author> author= authorService.getAllListContent();
        if (author.size() == 0) {
            response = authorService.createResponseArray(500, "Error", new JSONArray());
        } else {
            response = authorService.createResponseArray(200, "Success", new JSONArray(authorService.convertPOJOtoString(author)));
        }
       return mapper.readTree(response.toString());
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteAuthor(HttpServletRequest httpRequest, @PathVariable("id") long id ) throws IOException, JSONException {
        JSONObject response=new JSONObject();
        authorService.deletById(id);
        return "Delete Data";
    }

}
