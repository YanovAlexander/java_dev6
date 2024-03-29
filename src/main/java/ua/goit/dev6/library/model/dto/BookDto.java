package ua.goit.dev6.library.model.dto;

import java.util.Set;

public class BookDto {
    private Integer id;
    private String name;
    private Integer countPages;
    private Set<AuthorDto> authors;

    public BookDto(String name, int countPages, Set<AuthorDto> authors) {
        this.name = name;
        this.countPages = countPages;
        this.authors = authors;
    }

    public BookDto() {
    }

    public Set<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorDto> authors) {
        this.authors = authors;
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
