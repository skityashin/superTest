package com.skityashin.model;

import javax.persistence.*;
import java.util.List;

/**
 * Class {@link com.skityashin.model.Author}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 18.01.17
 */

@Entity
@Table(name = "author")
@NamedQuery(name = "Author.getALL", query = "select a from Author a")

public class Author {

    private long id_author;
    private String name;
    private List<Books> books;

    public Author() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_author", nullable = false)
    public long getId_author() {
        return id_author;
    }

    public void setId_author(long id_author) {
        this.id_author = id_author;
    }


    @Column(name = "name", unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", fetch = FetchType.LAZY, targetEntity = Books.class)
    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }
}


