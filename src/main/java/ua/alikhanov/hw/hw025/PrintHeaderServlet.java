package ua.alikhanov.hw.hw025;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class PrintHeaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userAgent = request.getHeader("User-Agent");
        response.getWriter().println("User-Agent: " + userAgent);
    }
}
