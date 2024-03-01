package ua.alikhanov.hw.hw025;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class GreetingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        response.getWriter().println("Привіт, " + name);
    }
}
