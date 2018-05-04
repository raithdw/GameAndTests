package tests;

public class Test1 {

    //Rotate a N by N array by 90 degrees.
    //counter clock-wise.

    public static void main(String[] args) {
        int numb = 3;
        int[][] N =
                {
                        {1, 2, 3,},
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

        rotateArray(numb, N);
        printArray( N);

    }

    private static void rotateArray(int numb, int arr[][]) {

        for (int i = 0; i < numb / 2; i++) {

            for (int j = i; j < numb - i - 1; j++) {

                int temp = arr[i][j];

                arr[i][j] = arr[j][numb - 1 - i];

                arr[j][numb - 1 - i] = arr[numb - 1 - i][numb - 1 - j];

                arr[numb - 1 - i][numb - 1 - j] = arr[numb - 1 - j][i];

                arr[numb - 1 - j][i] = temp;
            }
        }
    }

    private static void printArray(int arr[][]) {
        int nr = 3;
        for (int i = 0; i < nr; i++) {

            for (int j = 0; j < nr; j++) {
                System.out.print(" " + arr[i][j]);
            }
            System.out.print("\n");
        }
    }
}