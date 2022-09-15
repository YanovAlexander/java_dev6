package ua.goit.dev6.library.model.dao;

import java.util.Set;

public class BookDao {
    private Integer id;
    private String name;
    private Integer countPages;
    private Set<AuthorDao> authors;

    public BookDao(Integer id, String name, Integer countPages, Set<AuthorDao> authors) {
        this.id = id;
        this.name = name;
        this.countPages = countPages;
        this.authors=authors;
    }

    public Set<AuthorDao> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorDao> authors) {
        this.authors = authors;
    }

    public BookDao() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountPages() {
        return countPages;
    }

    public void setCountPages(Integer countPages) {
        this.countPages = countPages;
    }
}
