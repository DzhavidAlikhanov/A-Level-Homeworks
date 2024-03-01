package ua.alikhanov.hw.hw021.strategy;

public class Main {
    public static void main(String[] args) {
        Navigator navigator = new Navigator(new BusRouteStrategy());
        String busRoute = navigator.calculateRoute("Destination A");
        System.out.println("Bus route: " + busRoute);

        navigator.setRouteStrategy(new WalkRouteStrategy());
        String walkRoute = navigator.calculateRoute("Destination B");
        System.out.println("Walk route: " + walkRoute);
    }
}
