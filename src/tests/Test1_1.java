package tests;

public class Test1_1 {
    public static void main(String[] args) {
        //Rotate a N by N array by 90 degrees.
        //clock-wise.

        int N[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}

        };
        for (int i = 0; i < N.length; i++) {
            for (int j = 0; j < N[i].length; j++) {
                System.out.print(" " + N[i][j] + "");
            }
            System.out.println();
        }
        System.out.println("-------");

        rotateMatrix(N);

    }

    public static void rotateMatrix(int[][] matrix) {
        int nr = 3;
        if (matrix == null)
            return;
        if (matrix.length != matrix[0].length)
            return;
        rotateDiagonally(matrix);
        rotateMiddle(matrix);
        printArray(nr, matrix);
    }

    private static void rotateMiddle(int[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < size; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[size - 1 - i][j];
                matrix[size - 1 - i][j] = temp;
            }
        }
    }

    private static void rotateDiagonally(int[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[size - 1 - j][size - 1 - i];
                matrix[size - 1 - j][size - 1 - i] = temp;
            }
        }
    }

    private static void printArray(int nr, int arr[][]) {

        for (int i = 0; i < nr; i++) {

            for (int j = 0; j < nr; j++) {
                System.out.print(" " + arr[i][j]);
            }
            System.out.print("\n");
        }
    }

}
