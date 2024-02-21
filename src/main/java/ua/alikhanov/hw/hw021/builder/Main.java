package ua.alikhanov.hw.hw021.builder;

public class Main {
    public static void main(String[] args) {

        Computer computer = new Computer.Builder()
                .setProcessor("Intel i7")
                .setRam(16)
                .setStorage(512)
                .build();


        System.out.println("Processor: " + computer.getProcessor());
        System.out.println("RAM: " + computer.getRam() + "GB");
        System.out.println("Storage: " + computer.getStorage() + "GB");
    }
}