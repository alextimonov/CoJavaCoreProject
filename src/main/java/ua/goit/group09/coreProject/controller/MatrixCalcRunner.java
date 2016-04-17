package ua.goit.group09.coreProject.controller;

import ua.goit.group09.coreProject.data.MatrixData;
import ua.goit.group09.coreProject.logic.*;
import ua.goit.group09.coreProject.view.ConsolePrinter;
import ua.goit.group09.coreProject.view.MatrixCalcMenu;
import ua.goit.group09.coreProject.view.OutputMatrix;

import java.util.Scanner;

/**
 * Running class to provide user's interface to work with class Matrix
 */
public class MatrixCalcRunner {
    private static MatrixCalc matrixCalc =
            new MatrixCalcValidator
                    (new MatrixCalcProperMatricesValidator
                            (new MatrixCalcDefault()));

    public static void main(String[] args) {
        runUserInterface();
    }

    // provides user's interface with menu to make a choice
    public static void runUserInterface() {
        boolean isNeedToRun = true;
        Scanner sc = new Scanner(System.in);
        MatrixCalcMenu menu = new MatrixCalcMenu();
        while (isNeedToRun) {
            try {
                ConsolePrinter.printLineList(menu.getMenuLines());
                String s = sc.nextLine();
                int usersChoice = Integer.parseInt(s);
                switch (usersChoice) {
                    case 1: makeMathOperation(MathOperation.ADD_MATRICES);
                    break;

                    case 2: makeMathOperation(MathOperation.SUBTRACT_MATRICES);
                    break;

                    case 3: makeMathOperation(MathOperation.MULTIPLY_MATRICES);
                    break;

                    case 4: makeMathOperation(MathOperation.MULTIPLY_NUMBER_AND_MATRIX);
                    break;

                    case 5: isNeedToRun = false;
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

    private static void makeMathOperation(MathOperation mathOperation) {
        ConsolePrinter.printLine("Chosen operation is " + mathOperation.toString());
        MatrixData matrix1 = inputMatrix(mathOperation);
        ConsolePrinter.printLine("Inputted matrix #1:");
        ConsolePrinter.printLineList(OutputMatrix.matrixToStringList(matrix1));

        MatrixData matrix2 = null;
        double number = 0;
        if (mathOperation.equals(MathOperation.MULTIPLY_NUMBER_AND_MATRIX)) {
            number = InputMatrix.inputDouble("Input double multiplier:");
        }
        else {
            matrix2 = inputMatrix(mathOperation);
            ConsolePrinter.printLine("Inputted matrix #2:");
            ConsolePrinter.printLineList(OutputMatrix.matrixToStringList(matrix2));
        }
        MatrixData result = null;
        try {
            switch (mathOperation) {
                case ADD_MATRICES: {
                    result = matrixCalc.add(matrix1, matrix2);
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

    private static MatrixData inputMatrix(MathOperation mathOperation) {
        MatrixData matrix = new MatrixData();
        matrix.setLines(InputMatrix.inputNumberLines());
        matrix.setColumns(InputMatrix.inputNumberColumns());
        matrix.setArray(InputMatrix.inputArray(matrix.getLines(), matrix.getColumns()));
        return matrix;
    }
}
