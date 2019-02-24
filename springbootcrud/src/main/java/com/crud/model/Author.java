package com.crud.model;

import com.google.gson.annotations.Expose;

import javax.persistence.*;

/**
 * Created by Suvonkar Kundu on 2/23/2019.
 */
@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Expose
    long id;
    @Column(name = "author_name")
    @Expose
    String authorname;
    @Column(name = "author_email")
    @Expose
    String authormail;
    @Column(name = "author_address")
    @Expose
    String authoraddress;
    @Column(name = "author_phone")
    @Expose
    String authorphone;

    public Author(String authorname, String authormail, String authoraddress, String authorphone) {
        this.authorname = authorname;
        this.authormail = authormail;
        this.authoraddress = authoraddress;
        this.authorphone = authorphone;
    }

    public Author() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    public String getAuthormail() {
        return authormail;
    }

    public void setAuthormail(String authormail) {
        this.authormail = authormail;
    }

    public String getAuthoraddress() {
        return authoraddress;
    }

    public void setAuthoraddress(String authoraddress) {
        this.authoraddress = authoraddress;
    }

    public String getAuthorphone() {
        return authorphone;
    }

    public void setAuthorphone(String authorphone) {
        this.authorphone = authorphone;
    }
}
