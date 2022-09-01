package ua.goit.dev6.library.service.converter;

import ua.goit.dev6.library.model.dao.AuthorDao;
import ua.goit.dev6.library.model.dto.AuthorDto;

public class AuthorConverter implements Converter<AuthorDto, AuthorDao>{
    @Override
    public AuthorDto from(AuthorDao entity) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(entity.getId());
        authorDto.setFirstName(entity.getFirstName());
        authorDto.setLastName(entity.getLastName());
        authorDto.setEmail(entity.getEmail());
        return authorDto;
    }

    @Override
    public AuthorDao to(AuthorDto entity) {
        AuthorDao dao = new AuthorDao();
        dao.setId(entity.getId());
        dao.setFirstName(entity.getFirstName());
        dao.setLastName(entity.getLastName());
        dao.setEmail(entity.getEmail());
        return dao;
    }
}
