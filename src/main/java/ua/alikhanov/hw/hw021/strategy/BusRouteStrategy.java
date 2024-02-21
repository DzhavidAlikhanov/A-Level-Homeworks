package ua.alikhanov.hw.hw021.strategy;

public class BusRouteStrategy implements RouteStrategy {
    @Override
    public String calculateRoute(String destination) {
        return "Bus route to " + destination;
    }
}