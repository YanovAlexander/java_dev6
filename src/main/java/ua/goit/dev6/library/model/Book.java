package ua.goit.dev6.library.model;

import java.util.Objects;

public class Book extends Publication {
    private String author;

    public Book(String name, int countPages, String author) {
        super(name, countPages);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String print() {
        return "Book{" + super.print() + ", author= " + author + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author);
    }
}
