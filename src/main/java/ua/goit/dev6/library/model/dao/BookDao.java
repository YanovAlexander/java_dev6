package ua.goit.dev6.library.model.dao;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "book")
public class BookDao {
    private Integer id;
    private String name;
    private Integer countPages;
    private Set<AuthorDao> authors;

    public BookDao() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", length = 1000)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "count_pages")
    public Integer getCountPages() {
        return countPages;
    }

    public void setCountPages(Integer countPages) {
        this.countPages = countPages;
    }

    @ManyToMany
    @JoinTable (
            name = "author_book_relation",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "author_id") }
    )
    public Set<AuthorDao> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<AuthorDao> authors) {
        this.authors = authors;
    }
}
