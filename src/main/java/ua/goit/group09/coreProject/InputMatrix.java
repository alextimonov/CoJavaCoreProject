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
        return inputInt("Input matrix's number of lines:");
    }

    /**
     * provides input the matrix's columns number
     * @return          number of columns
     */
    public static int inputNumberColumns() {
        return inputInt("Input matrix's number of columns:");
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

    // provides input of array double[][]
    public static double[][] inputMatrix(int lines, int columns) {
        double[][] array = new double[lines][columns];
        System.out.println("Input array: ");
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = inputDouble("Input element array[" + i + "][" + j + "]: ");
            }
        }
        return array;
    }
}
