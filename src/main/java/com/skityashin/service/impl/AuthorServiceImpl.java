package com.skityashin.service.impl;


import com.skityashin.model.Author;
import com.skityashin.repository.AuthorRepository;
import com.skityashin.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class {@link AuthorServiceImpl}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 10.02.16
 */

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void createAuthor(Author author) {
        if(author == null) {
            throw new IllegalArgumentException("Author cannot be null");
        }
        authorRepository.createAuthor(author);
    }

    @Override
    public Author findByName(String name) {
        ///
        return null;
    }

    @Override
    public List<Author> getAllAuthor() {
        ///
        return null;
    }

    @Override
    public void deleteByName(String name) {
        ///

    }

    @Override
    public boolean isAuthorExist(String name) {
        ///
        return false;
    }
}
