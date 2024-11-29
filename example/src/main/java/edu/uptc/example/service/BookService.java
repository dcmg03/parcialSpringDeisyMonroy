package edu.uptc.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Obtener todos los libros
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    // Obtener un libro por ID
    public Book getById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
    

    // Guardar un libro nuevo
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    // Actualizar un libro existente
    public Book update(Long id, Book book) {
        return bookRepository.findById(id).map(existingBook -> {
            existingBook.setTitle(book.getTitle());
            existingBook.setPages(book.getPages());
            existingBook.setAuthor(book.getAuthor());
            return bookRepository.save(existingBook);
        }).orElse(null);
    }
    

    // Eliminar un libro por ID
    public boolean delete(Long id) {
        return bookRepository.findById(id).map(book -> {
            bookRepository.delete(book);
            return true;
        }).orElse(false);
    }
    
}

