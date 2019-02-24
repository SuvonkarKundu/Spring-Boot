package com.crud.Services;

import com.crud.Repository.AuthorRepository;
import com.crud.model.Author;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by Suvonkar Kundu on 2/23/2019.
 */
@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public ArrayList<Author> getAllListContent() {
        ArrayList<Author> listauthors = new ArrayList<>();
        authorRepository.findAll().forEach(listauthors::add);
        return listauthors;
    }

    public Author addListAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author getById(long id) {
        return authorRepository.findById(id);
    }

    public Author deletById(long id) {
        return authorRepository.deleteById(id);
    }

    public JSONObject createResponseArray(long code, String message, JSONArray jsonArray) throws JSONException {
        JSONObject response = new JSONObject();
        response.put("code", code);
        response.put("message", message);
        response.put("data", jsonArray);
        return response;
    }

    public String convertPOJOtoString(Object object){
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String value = gson.toJson(object);
        return value;
    }


    public JSONObject createResponseObject(long code, String message, JSONObject jsonObject) throws JSONException {
        JSONObject response = new JSONObject();
        response.put("code", code);
        response.put("message", message);
        response.put("data", jsonObject);
        return response;
    }
}
