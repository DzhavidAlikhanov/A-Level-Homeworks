package ua.alikhanov.hw.hw021.strategy;

public class CarRouteStrategy implements RouteStrategy {
    @Override
    public String calculateRoute(String destination) {
        return "Car route to " + destination;
    }
}