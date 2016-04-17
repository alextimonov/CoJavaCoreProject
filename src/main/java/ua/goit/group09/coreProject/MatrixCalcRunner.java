package ua.goit.group09.coreProject;

import java.util.Scanner;

enum MathOperation {
    ADD_MATRICES,
    SUBTRACT_MATRICES,
    MULTIPLY_MATRICES,
    MULTIPLY_NUMBER_AND_MATRIX
}

/**
 * Running class to provide user's interface to work with class Matrix
 */
public class MatrixCalcRunner {
    private static MatrixCalc matrixCalc =
            new MatrixCalcWithInvalidMatrices
                    (new MatrixCalcWithImproperMatrices
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
                PrintToConsole.printLineList(menu.getMenuLines());
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

    private static void makeMathOperation(MathOperation mathOperation) {
        PrintToConsole.printLine("Chosen operation is " + mathOperation.toString());
        MatrixData matrix1 = inputMatrix(mathOperation);
        PrintToConsole.printLine("Inputted matrix #1:");
        PrintToConsole.printLineList(OutputMatrix.matrixToStringList(matrix1));

        MatrixData matrix2 = null;
        double number = 0;
        if (mathOperation.equals(MathOperation.MULTIPLY_NUMBER_AND_MATRIX)) {
            number = InputMatrix.inputDouble("Input double multiplier:");
        }
        else {
            matrix2 = inputMatrix(mathOperation);
            PrintToConsole.printLine("Inputted matrix #2:");
            PrintToConsole.printLineList(OutputMatrix.matrixToStringList(matrix2));
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
            PrintToConsole.printLine("The result of " + mathOperation.toString() + " is:");
            PrintToConsole.printLineList(OutputMatrix.matrixToStringList(result));
        }
        catch (Exception e) {
            PrintToConsole.printLine(e.getMessage());
        }
        PrintToConsole.printLine("");
    }

    private static MatrixData inputMatrix(MathOperation mathOperation) {
        MatrixData matrix = new MatrixData();
        matrix.setLines(InputMatrix.inputNumberLines());
        matrix.setColumns(InputMatrix.inputNumberColumns());
        matrix.setArray(InputMatrix.inputArray(matrix.getLines(), matrix.getColumns()));
        return matrix;
    }
}
