package homeworks.hw5;

public class Task3 {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] transposedArray = transposeArray(array);

        printArray(array);
        System.out.println("После обмена строк и столбцов:");
        printArray(transposedArray);
    }

    public static int[][] transposeArray(int[][] arr) {
        int numRows = arr.length;
        int numCols = arr[0].length;
        int[][] transposedArr = new int[numCols][numRows];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                transposedArr[j][i] = arr[i][j];
            }
        }
        return transposedArr;
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
