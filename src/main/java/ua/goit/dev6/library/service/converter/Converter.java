package ua.goit.dev6.library.service.converter;

public interface Converter <E, T>{

    E from(T entity);
    T to (E entity);
}
