package com.skityashin.repository;


import com.skityashin.model.Books;

import java.util.List;

/**
 * Class {@link BooksRepository}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 10.02.16
 */

public interface BooksRepository {

    void createBooks(Books books);


    Books findByTitle(String title);


    List<Books> getAllBooks();


    void deleteByTitle(String title);


    boolean isBooksExist(String title);
}
