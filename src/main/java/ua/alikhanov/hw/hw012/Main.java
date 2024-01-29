package ua.alikhanov.hw.hw012;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> integerList = new ArrayList<>(3);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        ArrayUtil.printArray(integerList);

        integerList.add(4);
        ArrayUtil.printArray(integerList);

        integerList.add(0, 0);
        ArrayUtil.printArray(integerList);

        System.out.println("Index of 3: " + integerList.indexOf(3));
        System.out.println("Contains 5: " + integerList.isContains(5));

        integerList.remove(2);
        ArrayUtil.printArray(integerList);
    }
}