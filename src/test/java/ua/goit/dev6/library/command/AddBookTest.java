package ua.goit.dev6.library.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.goit.dev6.library.model.Book;
import ua.goit.dev6.library.repository.Repository;
import ua.goit.dev6.library.view.View;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class AddBookTest {

    private AddBook command;

    @Mock
    private View view;

    @Mock
    private Repository repository;

    @Captor
    private ArgumentCaptor<Book> bookCaptor;

    @BeforeEach
    void init() {
        command = new AddBook(view, repository);
    }

    @Test
    void testCanExecuteShouldReturnTrue() {
        String input = "add_book";
        boolean result = command.canExecute(input);

        assertTrue(result);
    }

    @Test
    void testCanExecuteShouldReturnFalse() {
        String input = "add_book1212";

        boolean result = command.canExecute(input);

        assertFalse(result);
    }

    @Test
    void testExecuteShouldCompleteWithNoErrors() {
        Book book = prepareBook();
        when(view.read())
                .thenReturn(book.getName())
                .thenReturn(String.valueOf(book.getCountPages()))
                .thenReturn(book.getAuthor());
        doNothing().when(repository).add(book);

        command.execute();

        verify(view, times(4)).write(anyString());
        verify(repository, times(1)).add(book);
        verify(view).write("Enter book name: ");
        verify(view).write("Enter count of pages: ");
        verify(view).write("Enter author of the book: ");
        verify(view).write("Book added. Thank you!");
    }

    @Test
    void testExecuteWhenIncorrectPageCountShouldThrowExceptionAndCompleteWithCorrectNumber() {
        Book book = prepareBook();
        String wrongPages = "abc";

        when(view.read())
                .thenReturn(book.getName())
                .thenReturn(wrongPages)
                .thenReturn(String.valueOf(book.getCountPages()))
                .thenReturn(book.getAuthor());

        doNothing().when(repository).add(book);

        command.execute();

        verify(view, times(6)).write(anyString());
        verify(view, times(2)).write("Enter count of pages: ");
        verify(repository, times(1)).add(book);
        verify(view).write("Enter book name: ");
        verify(view).write("Enter author of the book: ");
        verify(view).write("Book added. Thank you!");
        verify(view).write("Invalid value. Use digits");
    }

    @Test
    void testExecuteWithCaptureBookShouldComplete() {
        Book book = prepareBook();

        when(view.read())
                .thenReturn(book.getName())
                .thenReturn(String.valueOf(book.getCountPages()))
                .thenReturn(book.getAuthor());

        command.execute();

        verify(repository).add(bookCaptor.capture());

        Book savedBook = bookCaptor.getValue();

        verify(view, times(4)).write(anyString());
        verify(repository, times(1)).add(book);
        verify(view).write("Enter book name: ");
        verify(view).write("Enter author of the book: ");
        verify(view).write("Book added. Thank you!");
        verify(view).write("Enter count of pages: ");

        assertEquals(book.getAuthor(), savedBook.getAuthor());
        assertEquals(book.getName(), savedBook.getName());
        assertEquals(book.getCountPages(), savedBook.getCountPages());
    }

    private Book prepareBook() {
        return new Book("Kobzar", 1000, "Taras Shevchenko");
    }
}