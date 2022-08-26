package ua.goit.dev6.library.service;

import ua.goit.dev6.library.model.dao.AuthorDao;
import ua.goit.dev6.library.model.dto.AuthorDto;
import ua.goit.dev6.library.repository.AuthorRepository;
import ua.goit.dev6.library.service.converter.AuthorConverter;

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
}
