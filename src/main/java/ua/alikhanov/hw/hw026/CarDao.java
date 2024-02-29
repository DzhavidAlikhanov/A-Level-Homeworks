package ua.alikhanov.hw.hw026;

import java.util.ArrayList;
import java.util.List;

public final class CarDao {
    private static final CarDao INSTANCE = new CarDao();
    private final List<Car> carList = new ArrayList<>();

    public static CarDao getINSTANCE() {
        return INSTANCE;
    }

    public void saveCar(Car car) {
        carList.add(car);
    }

    public Car getById(int id) {
        return carList.stream().filter(car -> car.getId() == id).findAny().orElse(null);
    }

    public void deleteById(int id) {
        carList.removeIf(car -> car.getId() == id);
    }

    public List<Car> getAll() {
        return new ArrayList<>(carList);
    }

    private CarDao() {

    }
}
