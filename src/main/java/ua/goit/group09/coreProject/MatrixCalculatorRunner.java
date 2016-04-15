package ua.goit.group09.coreProject;

import java.util.List;
import java.util.Scanner;

/**
 * Running class to provide user's interface to work with class Matrix
 */
public class MatrixCalculatorRunner {
    public static void main(String[] args) {
        runUserInterface();
    }

    // provides user's interface
    public static void runUserInterface() {
        boolean isNeedToRun = true;
        Scanner sc = new Scanner(System.in);
        MatrixCalculatorMenu menu = new MatrixCalculatorMenu();
        while (isNeedToRun) {
            try {
                PrintToConsole.printLineList(menu.getMenuLines());
                String s = sc.nextLine();
                int choice = Integer.parseInt(s);
                switch (choice) {
                    case 1: {
                        addTwoMatrices();
                    }
                    break;
                    case 2: {
                        subtractTwoMatrices();
                    }
                    break;
                    case 3: {
                        multiplyTwoMatrices();
                    }
                    break;
                    case 4: {
                        multiplyNumberAndMatrix();
                    }
                    break;
                    case 5: {
                        isNeedToRun = false;
                    }
                    break;
                    default: {
                        PrintToConsole.printLine("Wrong input! Please, repeat.");
                    }
                }
            }
            catch (NumberFormatException e) {
                PrintToConsole.printLine("Input format Error!");
            }
        }
        sc.close();
    }

    private static void addTwoMatrices() {
        PrintToConsole.printLine("Adding two matrices");
        Matrix matrix1 = inputMatrix();
        Matrix matrix2 = inputMatrix();
        try {
            Matrix result = matrix1.add(matrix2);
            List<String> lineList = PrintMatrix.matrixToStringList(result);
            PrintToConsole.printLineList(lineList);
        }
        catch (Exception e) {
            PrintToConsole.printLine(e.getMessage());
        }
        PrintToConsole.printLine("");
    }

    private static void subtractTwoMatrices() {
        PrintToConsole.printLine("Subtracting two matrices");
        Matrix matrix1 = inputMatrix();
        Matrix matrix2 = inputMatrix();
        try {
            Matrix result = matrix1.subtract(matrix2);
            List<String> lineList = PrintMatrix.matrixToStringList(result);
            PrintToConsole.printLineList(lineList);
        } catch (Exception e) {
            PrintToConsole.printLine(e.getMessage());
        }
        PrintToConsole.printLine("");
    }

    private static void multiplyTwoMatrices() {
        PrintToConsole.printLine("Multiplying two matrices");
        Matrix matrix1 = inputMatrix();
        Matrix matrix2 = inputMatrix();
        try {
            Matrix result = matrix1.multiply(matrix2);
            List<String> lineList = PrintMatrix.matrixToStringList(result);
            PrintToConsole.printLineList(lineList);
        }
        catch (Exception e) {
            PrintToConsole.printLine(e.getMessage());
        }
        PrintToConsole.printLine("");
    }

    private static void multiplyNumberAndMatrix() {
        PrintToConsole.printLine("Multiplying double number and matrix");
        Matrix matrix = inputMatrix();
        double number = InputMatrix.inputDouble("Input double multiplier:");
        try {
            Matrix result = matrix.multNumber(number);
            List<String> lineList = PrintMatrix.matrixToStringList(result);
            PrintToConsole.printLineList(lineList);
        }
        catch (Exception e) {
            PrintToConsole.printLine(e.getMessage());
        }
        PrintToConsole.printLine("");
    }

    private static Matrix inputMatrix() {
        Matrix matrix1 = new Matrix();
        matrix1.setLines(InputMatrix.inputNumberLines());
        matrix1.setColumns(InputMatrix.inputNumberColumns());
        matrix1.setArray(InputMatrix.inputMatrix(matrix1.getLines(), matrix1.getColumns()));
        return matrix1;
    }
}
