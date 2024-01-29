package ua.alikhanov.hw.hw012;

public class ArrayUtil {
    public static <T> void printArray(ArrayList<T> list) {
        for (int i = 0; i < list.size; i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}