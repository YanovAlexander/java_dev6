package ua.goit.dev6.library.model.dao;

import java.util.Set;

public class AuthorDao {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<BookDao> books;

    public AuthorDao(Integer id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public AuthorDao(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public AuthorDao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<BookDao> getBooks() {
        return books;
    }

    public void setBooks(Set<BookDao> books) {
        this.books = books;
    }
}
