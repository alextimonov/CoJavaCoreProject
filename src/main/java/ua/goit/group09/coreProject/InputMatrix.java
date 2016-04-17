package ua.goit.group09.coreProject;

import java.util.Scanner;

/**
 * Provides input of needed data for class Matrix
 */
public class InputMatrix {

    /**
     * provides input the matrix's lines number
     * @return          number of lines
     */
    public static int inputNumberLines() {
        int lines = inputInt("Input matrix's integer number of lines that more than zero:");
        while (lines < 1) {
            lines = inputInt("Number of lines should be more than zero! Input one more time:");
        }
        return lines;
    }

    /**
     * provides input the matrix's columns number
     * @return          number of columns
     */
    public static int inputNumberColumns() {
        int columns = inputInt("Input matrix's integer number of columns that more than zero:");
        while (columns < 1) {
            columns = inputInt("Number of columns should be more than zero! Input one more time:");
        }
        return columns;
    }

    // provides input of array double[][]
    public static double[][] inputArray(int lines, int columns) {
        double[][] array = new double[lines][columns];
        System.out.println("Input array: ");
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = inputDouble("Input element array[" + i + "][" + j + "]: ");
            }
        }
        return array;
    }

    // provides input of integer value
    private static int inputInt(String message) {
        while(true) {
            try {
                System.out.println(message);
                Scanner scanner = new Scanner(System.in);
                return scanner.nextInt();
            }
            catch (Exception e) {
                System.out.println("Wrong input! Please, input integer value.");
            }
        }
    }

    // provides input of double value
    static double inputDouble(String message) {
        while(true) {
            try {
                System.out.println(message);
                Scanner scanner = new Scanner(System.in);
                return scanner.nextDouble();
            }
            catch (Exception e) {
                System.out.println("Wrong input! Please, input double value.");
            }
        }
    }
}
