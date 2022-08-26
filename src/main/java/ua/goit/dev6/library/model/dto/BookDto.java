package ua.goit.dev6.library.model.dto;

public class BookDto {
    private Integer id;
    private String name;
    private Integer countPages;
    private AuthorDto author;

    public BookDto(Integer id, String name, int countPages, AuthorDto author) {
        this.id = id;
        this.name = name;
        this.countPages = countPages;
        this.author = author;
    }

    public BookDto(String name, int countPages, AuthorDto author) {
        this.name = name;
        this.countPages = countPages;
        this.author = author;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
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
