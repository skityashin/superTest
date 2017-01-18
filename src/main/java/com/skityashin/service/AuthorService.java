package com.skityashin.service;

import com.skityashin.model.Author;
import java.util.List;

/**
 * Class {@link AuthorService}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 10.02.16
 */

public interface AuthorService {


    void createAuthor(Author author);


    Author findByName(String name);


    List<Author> getAllAuthor();


    void deleteByName(String name);


    boolean isAuthorExist(String name);
}
