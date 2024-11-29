package edu.uptc.example.entityes;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    @Column(nullable = false, length = 30)
    private String country;

    @Column(name = "birthday")
    private LocalDate birthday;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", orphanRemoval = true)
    private List<Book> books;

    public Author() {
    }

    public Author(Long id, String name, String country, LocalDate birthday, List<Book> books) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.birthday = birthday;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
