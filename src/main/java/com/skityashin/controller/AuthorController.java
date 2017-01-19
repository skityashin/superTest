package com.skityashin.controller;


import com.skityashin.dto.AuthorDto;
import com.skityashin.dto.BooksDto;
import com.skityashin.model.Author;
import com.skityashin.model.Books;
import com.skityashin.service.AuthorService;
import com.skityashin.service.BooksService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.ArrayList;
import java.util.List;



@Controller
@RequestMapping("/author")
public class AuthorController {

    private static final org.apache.log4j.Logger LOG = Logger.getLogger(AuthorController.class);

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BooksService booksService;

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String showForm() {
        BasicConfigurator.configure();
        return "create_author";
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createAuthor(@ModelAttribute AuthorDto authorDto, Model model) {


        Author author = authorService.findByName(authorDto.getName());

        if (author == null) {
            author = new Author();
            author.setName(authorDto.getName());
            authorService.createAuthor(author);
        }

        Books books = new Books();
        books.setTitle(authorDto.getName());
        books.setAuthor(author);

        try {
            booksService.createBooks(books);
        } catch (Exception e) {
            return "create_author"; //error
        }

        List<Books> booksList = author.getBooks();
        boolean exist = false;
        if (booksList != null) {
            for (Books next : booksList) {
                if (next.getTitle().equals(books.getTitle())) {
                    exist = true;
                    break;
                }
            }
        } else {
            booksList = new ArrayList<Books>();
            booksList.add(books);
            author.setBooks(booksList);
            exist = true;
        }
        if (!exist) {
            booksList.add(books);
            authorService.createAuthor(author);
        }

        model.addAttribute("name", author.getName());
        model.addAttribute("books", author.getBooks());
        return "one_books";
    }


    @RequestMapping(value = "/deleteAuthor", method = RequestMethod.POST)
    public String deleteAuthor(@ModelAttribute AuthorDto authorDto, Model model) {
        try {
            Author author = authorService.findByName(authorDto.getName());
            authorService.deleteByName(author.getName());
        } catch (Exception e) {
//            model.addAttribute("content", "\"" + booksDto.getNumber() + "\"" + " <font color=\"#FF0000\">not found!!!</font>");
            return "all_books";
        }
//        model.addAttribute("content", "\"" + authorDto.getContent() + "\"" + "  <font color=\"#01DF01\">is deleted!!!</font>");
        return "all_books";
    }


    @RequestMapping(value = "/deleteBooks", method = RequestMethod.POST)
    public String deletePhone(@ModelAttribute BooksDto booksDto, Model model) {
        try {
            Books books = booksService.findByTitle(booksDto.getTitle());
            booksService.deleteByTitle(books.getTitle());
        } catch (Exception e) {
//            model.addAttribute("content", "\"" + booksDto.getNumber() + "\"" + " <font color=\"#FF0000\">not found!!!</font>");
            return "all_books";
        }
//        model.addAttribute("content", "\"" + booksDto.getNumber() + "\"" + "  <font color=\"#01DF01\">is deleted!!!</font>");
        return "all_books";
    }

//    @RequestMapping(value = "/searchAddress", method = RequestMethod.GET)
//    public String findAddress(@ModelAttribute AddressDto addressDto, Model model) {
//        List<Address> address = addressService.findByContentPartial(addressDto.getContent());
//        model.addAttribute("address", address);
//        return "addressView";
//    }
//
//
//    @RequestMapping(value = "/searchPhone", method = RequestMethod.GET)
//    public String findPhone(@ModelAttribute PhoneDto phoneDto, Model model) {
//        List<Phone> phones = phoneService.findByNumberPartial(phoneDto.getNumber());
//        model.addAttribute("phones", phones);
//        return "phonesView";
//    }

}



















//
//import com.skityashin.dto.AuthorDto;
//import com.skityashin.model.Author;
//import com.skityashin.service.AuthorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.util.CollectionUtils;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
///**
// * Class {@link AuthorController}
// *
// * @author Skityashin Vladimir
// * @version 1.0
// * @since 18.01.17
// */
//
//@Controller
//@RequestMapping("/author")
//public class AuthorController {
//
//    @Autowired
//    private AuthorService authorService;
//
//    @RequestMapping(value = "/create", method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseEntity createAuthor(@RequestBody AuthorDto authorDto) {
//        if(authorDto == null) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//        Author author = new Author();
//        author.setName(authorDto.getName());
//        authorService.createAuthor(author);
//        return new ResponseEntity(author, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/delete/{name}", method = RequestMethod.DELETE)
//    @ResponseBody
//    public ResponseEntity deleteAuthor(@PathVariable String name) {
//        authorService.deleteByName(name);
//        return new ResponseEntity(HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/find/{name}", method = RequestMethod.GET)
//    @ResponseBody
//    public ResponseEntity findAuthor(@PathVariable String name) {
//        Author author = authorService.findByName(name);
//        if (author == null) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity(author, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
//    public ResponseEntity getAllAuthor() {
//        List<Author> authors = authorService.getAllAuthor();
//        if (CollectionUtils.isEmpty(authors)) {
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity(authors, HttpStatus.OK);
//    }
//
//
//}
//
