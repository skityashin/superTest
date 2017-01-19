package com.skityashin.repository.impl;


import com.skityashin.model.Author;
import com.skityashin.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Class {@link AuthorRepositoryImpl}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 18.01.17
 */

@Repository
@Transactional
public class AuthorRepositoryImpl implements AuthorRepository{

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void createAuthor(Author author) {
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null");
        }
        hibernateTemplate.saveOrUpdate(author);
    }

    @Override
    public Author findByName(String name) {
        return hibernateTemplate.get(Author.class, name);
    }

    @Override
    public List<Author> getAllAuthor() {
        return (List<Author>) hibernateTemplate.find("select * FROM Author");
    }

    @Override
    public void deleteByName(String name) {
        hibernateTemplate.delete(findByName(name));
    }

    @Override
    public boolean isAuthorExist(String name) {
        hibernateTemplate.contains(name);
        return false;
    }
}
