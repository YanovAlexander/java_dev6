package ua.goit.dev6.library.exceptions;

public class AuthorAlreadyExistException extends RuntimeException {
    public AuthorAlreadyExistException(String message) {
        super(message);
    }
}
