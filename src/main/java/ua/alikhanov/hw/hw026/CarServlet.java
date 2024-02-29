package ua.alikhanov.hw.hw026;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/cars/*")
public class CarServlet extends HttpServlet {

    private final Map<Integer, Car> carMap = new HashMap<>();
    private int idCounter = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String pathInfo = req.getPathInfo();

        if (pathInfo == null || pathInfo.equals("/")) {
            // GET all cars
            List<Car> cars = new ArrayList<>(carMap.values());
            resp.getWriter().write(cars.toString());
        } else {
            // GET specific car by id
            int id = Integer.parseInt(pathInfo.substring(1));
            Car car = carMap.get(id);
            if (car != null) {
                resp.getWriter().write(car.toString());
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Car not found");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        Car newCar = new Car(idCounter++, req.getParameter("brand"), req.getParameter("model"));
        carMap.put(newCar.getId(), newCar);
        resp.getWriter().write("Car added successfully");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String pathInfo = req.getPathInfo();
        if (pathInfo != null && !pathInfo.equals("/")) {
            int id = Integer.parseInt(pathInfo.substring(1));
            Car deletedCar = carMap.remove(id);
            if (deletedCar != null) {
                resp.getWriter().write("Car deleted successfully");
            } else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Car not found");
            }
        } else {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid request");
        }
    }
}
