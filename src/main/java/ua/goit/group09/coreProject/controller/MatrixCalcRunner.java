package ua.goit.group09.coreProject.controller;

import ua.goit.group09.coreProject.data.Matrix;
import ua.goit.group09.coreProject.logic.*;
import ua.goit.group09.coreProject.view.ConsolePrinter;
import ua.goit.group09.coreProject.view.MatrixCalcMenu;
import ua.goit.group09.coreProject.view.OutputMatrix;

import java.util.Scanner;

/**
 * Running class to provide user's interface to work with class Matrix
 */
public class MatrixCalcRunner {
    public static final int CHOICE_SUM_MATRICES = 1;
    public static final int CHOICE_SUBTRACT_MATRICES = 2;
    public static final int CHOICE_MULT_MATRICES = 3;
    public static final int CHOICE_MULT_NUMBER = 4;
    public static final int CHOICE_EXIT = 5;

    private static MatrixCalc matrixCalc =
            new MatricesValidator
                    (new MatricesCanBeOperatedValidator
                            (new MatrixCalcDefault()));
    private static MatrixCalcMenu menu = new MatrixCalcMenu();

    public static void main(String[] args) {
        runUserInterface();
    }

    // provides user's interface with menu to make a choice
    public static void runUserInterface() {
        boolean isNeedToRun = true;
        Scanner sc = new Scanner(System.in);

        while (isNeedToRun) {
            try {
                ConsolePrinter.printLineList(menu.getMenuLines());
                String s = sc.nextLine();
                int usersChoice = Integer.parseInt(s);
                switch (usersChoice) {
                    case CHOICE_SUM_MATRICES: {
                        makeMathOperation(MathOperation.SUM_MATRICES);
                    }
                    break;
                    case CHOICE_SUBTRACT_MATRICES: {
                        makeMathOperation(MathOperation.SUBTRACT_MATRICES);
                    }
                    break;
                    case CHOICE_MULT_MATRICES: {
                        makeMathOperation(MathOperation.MULTIPLY_MATRICES);
                    }
                    break;
                    case CHOICE_MULT_NUMBER: {
                        makeMathOperation(MathOperation.MULTIPLY_NUMBER_AND_MATRIX);
                    }
                    break;
                    case CHOICE_EXIT: {
                        isNeedToRun = false;
                    }
                    break;
                    default: {
                        ConsolePrinter.printLine("Wrong input! Please, repeat.");
                    }
                }
            }
            catch (NumberFormatException e) {
                ConsolePrinter.printLine("Input format Error!");
            }
        }
        sc.close();
    }

    // makes chosen by user math operation: invokes input of arguments and than chosen operation
    private static void makeMathOperation(MathOperation mathOperation) {
        ConsolePrinter.printLine("Chosen operation is " + mathOperation.toString());
        Matrix matrix1 = InputMatrix.inputMatrixData();
        ConsolePrinter.printLine("Inputted matrix #1:");
        ConsolePrinter.printLineList(OutputMatrix.matrixToStringList(matrix1));

        Matrix matrix2 = null;
        double number = 0;
        if (mathOperation.equals(MathOperation.MULTIPLY_NUMBER_AND_MATRIX)) {
            number = InputMatrix.inputDouble("Input double multiplier:");
        }
        else {
            matrix2 = InputMatrix.inputMatrixData();
            ConsolePrinter.printLine("Inputted matrix #2:");
            ConsolePrinter.printLineList(OutputMatrix.matrixToStringList(matrix2));
        }
        Matrix result = null;
        try {
            switch (mathOperation) {
                case SUM_MATRICES: {
                    result = matrixCalc.sum(matrix1, matrix2);
                }
                break;
                case SUBTRACT_MATRICES: {
                    result = matrixCalc.subtract(matrix1, matrix2);
                }
                break;
                case MULTIPLY_MATRICES: {
                    result = matrixCalc.multiply(matrix1, matrix2);
                }
                break;
                case MULTIPLY_NUMBER_AND_MATRIX: {
                    result = matrixCalc.multiply(number, matrix1);
                }
            }
            ConsolePrinter.printLine("The result of " + mathOperation.toString() + " is:");
            ConsolePrinter.printLineList(OutputMatrix.matrixToStringList(result));
        }
        catch (Exception e) {
            ConsolePrinter.printLine(e.getMessage());
        }
        ConsolePrinter.printLine("");
    }
}
