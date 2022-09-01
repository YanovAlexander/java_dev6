package ua.goit.dev6.library.service;

import ua.goit.dev6.library.exceptions.AuthorAlreadyExistException;
import ua.goit.dev6.library.model.dao.AuthorDao;
import ua.goit.dev6.library.model.dto.AuthorDto;
import ua.goit.dev6.library.repository.AuthorRepository;
import ua.goit.dev6.library.service.converter.AuthorConverter;

import java.util.Optional;

public class AuthorService {

    private AuthorRepository repository;
    private AuthorConverter authorConverter;

    public AuthorService(AuthorRepository repository, AuthorConverter authorConverter) {
        this.repository = repository;
        this.authorConverter = authorConverter;
    }

    public AuthorDto save(AuthorDto dto) {
        AuthorDao authorDao = repository.save(authorConverter.to(dto));
        return authorConverter.from(authorDao);
    }

    public Optional<AuthorDto> findByEmail(String email) {
        Optional<AuthorDao> byEmail = repository.findByEmail(email);
        return byEmail.map(authorDao -> authorConverter.from(authorDao));
    }

    public void validateAuthor(AuthorDto savedAuthor, AuthorDto newAuthor) {
        if(!savedAuthor.getFirstName().equals(newAuthor.getFirstName()) ||
                !savedAuthor.getLastName().equals(newAuthor.getLastName())) {
            throw new AuthorAlreadyExistException(String.format("Author with email %s already exist with different " +
                            "name %s %s" , savedAuthor.getEmail(), savedAuthor.getFirstName(), savedAuthor.getLastName()));
        }
    }
}
