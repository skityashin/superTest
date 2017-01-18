package com.skityashin.controller;

import com.skityashin.dto.AuthorDto;
import com.skityashin.dto.BooksDto;
import com.skityashin.model.Author;
import com.skityashin.model.Books;
import com.skityashin.service.AuthorService;
import com.skityashin.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

/**
 * Class {@link BooksController}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 18.01.17
 */

@Controller
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService booksService;
    @Autowired
    private AuthorService authorService;

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String showForm() {
        return "create_books";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String showResult(@ModelAttribute BooksDto booksDto, @ModelAttribute AuthorDto authorDto, Model model) {
        if (booksDto == null) {
            return "create_books";
        }
        Author author = authorService.findByName(authorDto.getName());

        author.setName(authorDto.getName());
        Books books = new Books();

        books.setTitle(booksDto.getTitle());
        books.setAuthor(author);

        booksService.createBooks(books);
        model.addAttribute("title", books.getTitle());
        model.addAttribute("id_books", books.getId_books());
        model.addAttribute("author", books.getAuthor());

        return "one_books";
    }

    @RequestMapping(value = "/delete/{name}", method = RequestMethod.POST)
    @ResponseBody
    @SuppressWarnings("unchecked")
    public ResponseEntity deleteBooks(@PathVariable String name) {
        booksService.deleteByTitle(name);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/find/{name}", method = RequestMethod.GET)
    public String findProduct(@PathVariable String name, Model model) {
        Books books = booksService.findByTitle(name);
        model.addAttribute("title", books.getTitle());
        model.addAttribute("id_books", books.getId_books());
        model.addAttribute("author", books.getAuthor());
        return "one_books";
    }


    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
    public String getAllBooks(Model model) {
        List<Books> books = booksService.getAllBooks();
        model.addAttribute("books", books);
        return "all_books";
    }



}
