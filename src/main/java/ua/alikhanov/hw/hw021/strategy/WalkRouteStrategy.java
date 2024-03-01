package ua.alikhanov.hw.hw021.strategy;

public class WalkRouteStrategy implements RouteStrategy {
    @Override
    public String calculateRoute(String destination) {
        return "Walking route to " + destination;
    }
}