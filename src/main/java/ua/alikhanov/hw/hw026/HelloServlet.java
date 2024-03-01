package ua.alikhanov.hw.hw026;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/cars/*")
public class HelloServlet extends HttpServlet {
    private final CarDao carDao = CarDao.getINSTANCE();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String contextPath = req.getPathInfo();
        resp.setContentType("application/json");
        if (contextPath == null || contextPath.equals("/")) {
            // GET all cars
            resp.getWriter().write(mapper.writeValueAsString(carDao.getAll()));
        } else {
            // GET specific car by id
            int id = Integer.parseInt(contextPath.substring(1));
            Car car = carDao.getById(id);
            if (car != null) {
                resp.getWriter().write(mapper.writeValueAsString(car));
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Car not found");
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String contextPath = req.getPathInfo();
        if (contextPath != null && !contextPath.equals("/")) {
            int id = Integer.parseInt(contextPath.substring(1));
            carDao.deleteById(id);
            resp.getWriter().write("Car deleted successfully");
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader reader = req.getReader();
        String json = reader.readLine();
        Car car = mapper.readValue(json, Car.class);
        carDao.saveCar(car);
        resp.getWriter().write("Car added successfully");
    }
}
