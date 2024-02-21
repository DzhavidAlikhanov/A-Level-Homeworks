package ua.alikhanov.hw.hw021.copy;

public record Address(String street, String city) {
    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
