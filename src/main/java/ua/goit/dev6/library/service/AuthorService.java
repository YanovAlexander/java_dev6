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

    public AuthorDao save(AuthorDto dto) {
        return repository.save(authorConverter.to(dto));
    }

    public Optional<AuthorDao> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    public void validateAuthor(AuthorDao authorDao, AuthorDto authorDto) {
        if(!authorDao.getFirstName().equals(authorDto.getFirstName()) ||
                !authorDao.getLastName().equals(authorDto.getLastName())) {
            throw new AuthorAlreadyExistException(String.format("Author with email %s already exist with different " +
                            "name %s %s" , authorDto.getEmail(), authorDto.getFirstName(), authorDto.getLastName()));
        }
    }
}
