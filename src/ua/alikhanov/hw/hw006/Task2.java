package ua.alikhanov.hw.hw006;

public class Task2 {
    public static void main(String[] args) {
        int[][] triangle = new int[5][];
        triangle[0] = new int[1];
        triangle[1] = new int[2];
        triangle[2] = new int[3];
        triangle[3] = new int[4];
        triangle[4] = new int[5];
        for (int i = 0; i < triangle.length; i++) {
            System.out.println(triangle.length + "!");
            System.out.println("i = " + i);
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.println(triangle[i].length);
                triangle[i][j] = 0;
            }
        }
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                /*
                Ошибка на строке №20, нашел c помощью дебагера поочередно перебирая каждую строку и
                сммотрел что происходит, таким образом нашел, что вместо переменной "j" указана переменная "i",
                 что приводило к тому, что пыталось обратиться к индексу за пределами массива и выдавало ошибку
                 указывающую на это.
                */
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}
