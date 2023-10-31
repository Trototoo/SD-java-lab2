package sd.java.lab2;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Lab2Application {
    Lab2Application(){}

    public static void run() {
        long[][] matrixA;
        long[][] matrixB;
        long[][] resultMatrix;

        Scanner scanner = new Scanner(System.in);
        final String[] sides = new String[]{"width", "height"};
        int[] sidesSize = new int[2];

        for (int index = 0; index < 2; index++) {
            try {
                System.out.print("Enter " + sides[index] + ": ");
                int input = scanner.nextInt();

                if (input >= 1) {
                    sidesSize[index] = input;
                } else {
                    System.out.println("Please enter positive number.");
                    index--;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                index--;
                scanner.next();
            }
        }

        final int width = sidesSize[0];
        final int height = sidesSize[1];

        Random random = new Random();
        matrixA = new long[height][width];
        matrixB = new long[height][width];
        resultMatrix = new long[height][width];


        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                matrixA[i][j] = random.nextLong(-100,100);
                matrixB[i][j] = random.nextLong(-100,100);
                resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        System.out.println("\nMatrix A: \n");
        printOutMatrix(matrixA);

        System.out.println("\nMatrix B: \n");
        printOutMatrix(matrixB);

        System.out.println("\nResult matrix: \n");
        printOutMatrix(resultMatrix);

        System.out.println("\nSum of the lowest in the row of matrix: " + sumOfTheLowestInTheRow(resultMatrix));

    }

    private static void printOutMatrix(long[][] matrix) {
        for (long[] longs : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == matrix[0].length - 1) {
                    System.out.print(longs[j]);
                } else {
                    System.out.print(longs[j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static long sumOfTheLowestInTheRow(long[][] matrix) {
        long sum = 0;
        for (long[] longs : matrix) {
            long lowest = longs[0];
            for (int j = 0; j < matrix[0].length; j++) {
                if (longs[j] < lowest) {
                    lowest = longs[j];
                }
            }
            sum += lowest;
        }
        return sum;
    }
}
