package com.skityashin.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skityashin.model.Author;

/**
 * Class {@link BooksDto}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 18.01.17
 */

@JsonAutoDetect
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class BooksDto {

    private String title;
    private Author author;

    public BooksDto() {
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
