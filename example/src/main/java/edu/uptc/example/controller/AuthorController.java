package edu.uptc.example.controller;

import edu.uptc.example.service.AuthorService;
import edu.uptc.handling.ResponseHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<Object> getAuthors() {
        try {
            List<Author> result = authorService.getAuthors();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAuthor(@PathVariable("id") long id) {
        try {
            Author result = authorService.getAuthor(id);
            if (result == null) {
                return ResponseHandler.generateResponse("Author not found", HttpStatus.NOT_FOUND, null);
            }
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }


    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Author author) {
        try {
            Author result = authorService.save(author);
            return ResponseHandler.generateResponse("Success", HttpStatus.CREATED, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
