package by.javaguru.je.jdbc.servlet;

import by.javaguru.je.jdbc.dto.UserDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {
    public static final String USER = "user";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var session = req.getSession();
        System.out.println(session.isNew());
        var user = session.getAttribute(USER);
        if (user == null)
            user = UserDto.builder()
                    .id(5)
                    .email("aaa@aaa.com")
                    .build();
        session.setAttribute(USER, user);
    }
}
