package ua.alikhanov.hw.hw9;

public class Animal {
    private String name;
    private int hoursOfSleeping;
    private String food;

    public Animal(String name, int hoursOfSleeping, String food) {
        this.name = name;
        this.hoursOfSleeping = hoursOfSleeping;
        this.food = food;
    }

    public void displayVariables() {
        System.out.println("Имя: " + name);
        System.out.println("Часы сна: " + hoursOfSleeping);
        System.out.println("Еда: " + food);
    }

    public int getHoursOfSleeping() {
        return hoursOfSleeping;
    }

    public String getFood() {
        return food;
    }
    public String getName(){
        return name;
    }
}
