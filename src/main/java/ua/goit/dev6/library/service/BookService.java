package ua.goit.dev6.library.service;

import ua.goit.dev6.library.exceptions.AuthorAlreadyExistException;
import ua.goit.dev6.library.model.dao.AuthorDao;
import ua.goit.dev6.library.model.dao.BookDao;
import ua.goit.dev6.library.model.dto.AuthorDto;
import ua.goit.dev6.library.model.dto.BookDto;
import ua.goit.dev6.library.repository.AuthorBookRelationRepository;
import ua.goit.dev6.library.repository.BookRepository;
import ua.goit.dev6.library.service.converter.BookConverter;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class BookService {
    private AuthorService authorService;
    private BookRepository bookRepository;
    private BookConverter converter;

    private AuthorBookRelationRepository authorBookRelationRepository;

    public BookService(AuthorService authorService, BookRepository bookRepository, BookConverter converter,
                       AuthorBookRelationRepository authorBookRelationRepository) {
        this.authorService = authorService;
        this.bookRepository = bookRepository;
        this.converter = converter;
        this.authorBookRelationRepository = authorBookRelationRepository;
    }

    public void save(BookDto dto) {
        Set<AuthorDto> authors = dto.getAuthors().stream().map(author -> authorService.findByEmail(author.getEmail())
                .orElseGet(() -> authorService.save(author))).collect(Collectors.toSet());
        Set<Integer> authorsIds = authors.stream().map(AuthorDto::getId).collect(Collectors.toSet());
        //authorService.validateAuthor(authorDto, dto.getAuthor());
        dto.setAuthors(authors);
        BookDao book = converter.to(dto);
        bookRepository.save(book);
        authorBookRelationRepository.save(authorsIds, book.getId());
    }
}
