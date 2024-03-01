package ua.alikhanov.hw.hw025;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String operation = request.getParameter("op");
            int n1 = Integer.parseInt(request.getParameter("n1"));
            int n2 = Integer.parseInt(request.getParameter("n2"));

            int result = 0;

            switch (operation) {
                case "add":
                    result = n1 + n2;
                    break;
                case "subtract":
                    result = n1 - n2;
                    break;
                case "multiply":
                    result = n1 * n2;
                    break;
                case "divide":
                    result = n1 / n2;
                    break;
                default:
                    break;
            }

            response.getWriter().println("операція = " + operation);
            response.getWriter().println("n1 + n2 = " + result);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
