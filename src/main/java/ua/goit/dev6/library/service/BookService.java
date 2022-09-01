package ua.goit.dev6.library.service;

import ua.goit.dev6.library.exceptions.AuthorAlreadyExistException;
import ua.goit.dev6.library.model.dao.AuthorDao;
import ua.goit.dev6.library.model.dao.BookDao;
import ua.goit.dev6.library.model.dto.AuthorDto;
import ua.goit.dev6.library.model.dto.BookDto;
import ua.goit.dev6.library.repository.BookRepository;
import ua.goit.dev6.library.service.converter.BookConverter;

import java.util.Optional;

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
        AuthorDto authorDto = authorService.findByEmail(dto.getAuthor().getEmail())
                .orElseGet(() -> authorService.save(dto.getAuthor()));

        authorService.validateAuthor(authorDto, dto.getAuthor());
        dto.setAuthor(authorDto);
        BookDao book = converter.to(dto);
        bookRepository.save(book);
    }
}
