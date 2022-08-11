package ua.goit.dev6.library.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ua.goit.dev6.library.view.View;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class HelpTest {
    private Help command;

    @Mock
    private View view;

    @BeforeEach
    void init() {
        command = new Help(view);
    }

    @Test
    void testCanExecuteShouldReturnTrue() {
        String input = "help";
        boolean result = command.canExecute(input);

        assertTrue(result);
    }

    @Test
    void testCanExecuteShouldReturnFalse() {
        String input = "help1212";

        boolean result = command.canExecute(input);

        assertFalse(result);
    }

    @Test
    void testExecuteShouldCompleteWithoutError() {
        command.execute();

        verify(view, times(4)).write(any());
        verify(view).write("Enter help to see all command");
        verify(view).write("Enter exit to exit program");
        verify(view).write("Enter add_book command to add book to the library");
        verify(view).write("Enter add journal command to add journal to the library");
    }
}