package ua.goit.dev6.library.service.converter;

import ua.goit.dev6.library.model.dao.BookDao;
import ua.goit.dev6.library.model.dto.BookDto;

import java.util.stream.Collectors;

public class BookConverter implements Converter<BookDto, BookDao>{

    private AuthorConverter converter;

    public BookConverter(AuthorConverter converter) {
        this.converter = converter;
    }

    @Override
    public BookDto from(BookDao entity) {
        return null;
    }

    @Override
    public BookDao to(BookDto entity) {
        BookDao dao = new BookDao();
        dao.setId(entity.getId());
        dao.setName(entity.getName());
        dao.setCountPages(entity.getCountPages());
        dao.setAuthors(entity.getAuthors().stream().map(converter::to)
                .collect(Collectors.toSet()));
        return dao;
    }
}
