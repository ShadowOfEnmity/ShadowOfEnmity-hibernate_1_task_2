package by.javaguru.je.jdbc.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Log4j2
@WebServlet("/dispatcher")
public class DispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        var dispatcher = req.getRequestDispatcher("/flights");
        req.setAttribute("dispathcer", true);
        try {
            dispatcher.include(req, resp);
            var writer = resp.getWriter();
            writer.write("<h1>DISPATCHER</h1>");
        } catch (IOException e) {
            log.error("The following error is occurred {}", () -> e);
            throw new RuntimeException(e);
        }
    }
}
