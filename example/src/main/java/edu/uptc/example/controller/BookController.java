package edu.uptc.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.uptc.handling.ResponseHandler;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Obtener todos los libros
    @GetMapping
    public ResponseEntity<Object> getBooks() {
        try {
            List<Book> result = bookService.getAll();
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Obtener un libro por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getBookById(@PathVariable Long id) {
        try {
            Book result = bookService.getById(id);
            if (result == null) {
                return ResponseHandler.generateResponse("Book not found", HttpStatus.NOT_FOUND, null);
            }
            return ResponseHandler.generateResponse("Success", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Guardar un nuevo libro
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Book book) {
        try {
            Book savedBook = bookService.save(book);
            return ResponseHandler.generateResponse("Book created successfully", HttpStatus.CREATED, savedBook);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Actualizar un libro existente
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Book book) {
        try {
            Book updatedBook = bookService.update(id, book);
            if (updatedBook == null) {
                return ResponseHandler.generateResponse("Book not found", HttpStatus.NOT_FOUND, null);
            }
            return ResponseHandler.generateResponse("Book updated successfully", HttpStatus.OK, updatedBook);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    // Eliminar un libro por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        try {
            boolean deleted = bookService.delete(id);
            if (!deleted) {
                return ResponseHandler.generateResponse("Book not found", HttpStatus.NOT_FOUND, null);
            }
            return ResponseHandler.generateResponse("Book deleted successfully", HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}

    //terminar los endpoint de libro
    //que pasa cuando se elimina un autor --> cascada
    
