package edu.uptc.example.entityes;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false)
    private short pages;

    @ManyToOne
    @JoinColumn(name = "ref_author", nullable = false)
    private Author author;

    // Constructor sin argumentos (requerido por JPA)
    public Book() {
    }

    // Constructor con argumentos
    public Book(Long id, String title, short pages, Author author) {
        this.id = id;
        this.title = title;
        this.pages = pages;
        this.author = author;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public short getPages() {
        return pages;
    }

    public void setPages(short pages) {
        this.pages = pages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
