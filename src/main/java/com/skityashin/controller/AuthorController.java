package com.skityashin.controller;

import com.skityashin.dto.AuthorDto;
import com.skityashin.model.Author;
import com.skityashin.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class {@link AuthorController}
 *
 * @author Skityashin Vladimir
 * @version 1.0
 * @since 18.01.17
 */

@Controller
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity createCategory(@RequestBody AuthorDto authorDto) {
        if(authorDto == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        Author author = new Author();
        author.setName(authorDto.getName());
        authorService.createAuthor(author);
        return new ResponseEntity(author, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{name}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity deleteCategory(@PathVariable String name) {
        authorService.deleteByName(name);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/find/{name}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity findCategory(@PathVariable String name) {
        Author author = authorService.findByName(name);
        if (author == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(author, HttpStatus.OK);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public ResponseEntity getAllProducts() {
        List<Author> authors = authorService.getAllAuthor();
        if (CollectionUtils.isEmpty(authors)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(authors, HttpStatus.OK);
    }


}

