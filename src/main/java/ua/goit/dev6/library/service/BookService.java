package ua.goit.dev6.library.service;

import ua.goit.dev6.library.model.dao.AuthorDao;
import ua.goit.dev6.library.model.dao.BookDao;
import ua.goit.dev6.library.model.dto.BookDto;
import ua.goit.dev6.library.repository.BookRepository;
import ua.goit.dev6.library.service.converter.BookConverter;

public class BookService {
    private AuthorService authorService;
    private BookRepository bookRepository;
    private BookConverter converter;

    public BookService(AuthorService authorService, BookRepository bookRepository, BookConverter converter) {
        this.authorService = authorService;
        this.bookRepository = bookRepository;
        this.converter = converter;
    }

    public void save(BookDto dto) {
        AuthorDao saveAuthor = authorService.save(dto.getAuthor());
        BookDao book = converter.to(dto);
        book.setAuthor(saveAuthor);
        bookRepository.save(book);
    }
}
