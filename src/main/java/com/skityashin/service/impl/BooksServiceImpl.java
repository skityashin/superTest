package com.skityashin.service.impl;


import com.skityashin.model.Books;
import com.skityashin.repository.BooksRepository;
import com.skityashin.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class {@link BooksServiceImpl}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 18.01.17
 */

@Service
public class BooksServiceImpl implements BooksService {

    @Autowired
    private BooksRepository booksRepository;

    @Override
    public void createBooks(Books books) {
        if (books == null) {
            throw new IllegalArgumentException("Books cannot be null");
        }
        booksRepository.createBooks(books);
    }

    @Override
    public Books findByTitle(String title) {
        return booksRepository.findByTitle(title);
    }

    @Override
    public List<Books> getAllBooks() {
        return booksRepository.getAllBooks();
    }

    @Override
    public void deleteByTitle(String title) {
        booksRepository.deleteByTitle(title);
    }

    @Override
    public boolean isBooksExist(String title) {
        return booksRepository.isBooksExist(title);
    }
}
