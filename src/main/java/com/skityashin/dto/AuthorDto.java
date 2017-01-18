package com.skityashin.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.skityashin.model.Books;


/**
 * Class {@link AuthorDto}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 18.01.17
 */

@JsonAutoDetect
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class AuthorDto {

    private String name;
    private Books books;

    public AuthorDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }
}