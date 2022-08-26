package ua.goit.dev6.library.model.dao;

public class BookDao {
    private Integer id;
    private String name;
    private Integer countPages;
    private AuthorDao author;

    public BookDao(Integer id, String name, Integer countPages, AuthorDao author) {
        this.id = id;
        this.name = name;
        this.countPages = countPages;
        this.author = author;
    }

    public BookDao(String name, Integer countPages, AuthorDao author) {
        this.name = name;
        this.countPages = countPages;
        this.author = author;
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

    public AuthorDao getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDao author) {
        this.author = author;
    }
}
