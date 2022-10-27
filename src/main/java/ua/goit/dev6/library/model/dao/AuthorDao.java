package ua.goit.dev6.library.model.dao;

import javax.persistence.*;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name = "author")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "Author")
public class AuthorDao {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private Set<BookDao> books;

    public AuthorDao() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "first_name", length = 1000)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", length = 1000)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email", length = 1000)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToMany(mappedBy = "authors")
    public Set<BookDao> getBooks() {
        return books;
    }

    public void setBooks(Set<BookDao> books) {
        this.books = books;
    }
}
