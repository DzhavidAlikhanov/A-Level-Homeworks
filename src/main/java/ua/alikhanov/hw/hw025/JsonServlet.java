package ua.alikhanov.hw.hw025;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JsonServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder jsonBody = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;

            while ((line = reader.readLine()) != null) {
                jsonBody.append(line);
            }
        } catch (IOException e) {

            e.printStackTrace();
        }


        System.out.println("Received JSON: " + jsonBody.toString());
        response.getWriter().println("Received JSON: " + jsonBody.toString());
    }
}
