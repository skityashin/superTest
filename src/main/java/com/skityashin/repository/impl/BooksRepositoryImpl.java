package com.skityashin.repository.impl;


import com.skityashin.model.Books;
import com.skityashin.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Class {@link BooksRepositoryImpl}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 18.01.17
 */

@Repository
@Transactional
public class BooksRepositoryImpl implements BooksRepository {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void createBooks(Books books) {
        hibernateTemplate.saveOrUpdate(books);
    }

    @Override
    public Books findByTitle(String title) {
        return hibernateTemplate.get(Books.class, title);
    }

    @Override
    public List<Books> getAllBooks() {
        return (List<Books>) hibernateTemplate.find("select * FROM Books");
    }

    @Override
    public void deleteByTitle(String title) {
        hibernateTemplate.delete(findByTitle(title));
    }

    @Override
    public boolean isBooksExist(String title) {
        return hibernateTemplate.contains(title);
    }
}
