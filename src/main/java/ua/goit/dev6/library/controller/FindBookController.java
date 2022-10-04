package ua.goit.dev6.library.controller;

import ua.goit.dev6.library.model.dto.AuthorDto;
import ua.goit.dev6.library.model.dto.BookDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(urlPatterns = "/books")
public class FindBookController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookName = req.getParameter("bookName");
        BookDto bookDto = new BookDto(1, bookName, 100, Set.of(new AuthorDto("Oleksandr", "Yanov", "email.com"),
                new AuthorDto("Pavlo", "Pavlo", "pavlo@email.com")));
        req.setAttribute("book", bookDto);
        req.getRequestDispatcher("/jsp/findBook.jsp").forward(req, resp);
    }
}
