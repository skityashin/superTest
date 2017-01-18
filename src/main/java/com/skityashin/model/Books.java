package com.skityashin.model;

import javax.persistence.*;

/**
 * Class {@link Books}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 18.01.17
 */


@Entity
@Table(name = "books")
@NamedQuery(name = "Books.getALL", query = "select b from Books b")

public class Books {

    private long id_books;
    private String title;
    private Author author;


    public Books() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_books", nullable = false)
    public long getId_books() {
        return id_books;
    }

    public void setId_books(long id_books) {
        this.id_books = id_books;
    }


    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @ManyToOne
    @JoinColumn(name = "author_id")
    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }


}
