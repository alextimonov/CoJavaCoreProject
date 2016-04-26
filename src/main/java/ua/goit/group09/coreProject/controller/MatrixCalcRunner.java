package ua.goit.group09.coreProject.controller;

import ua.goit.group09.coreProject.data.Matrix;
import ua.goit.group09.coreProject.logic.*;
import ua.goit.group09.coreProject.view.*;

import java.util.Scanner;

/**
 * Runner class to provide user's interface to work with class Matrix
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

    /**
     * provides user's interface with menu to make a choice
     */
    public static void runUserInterface() {
        boolean isNeedToRun = true;
        Scanner sc = new Scanner(System.in);
        Evaluator evaluator = null;

        while (isNeedToRun) {
            try {
                ConsolePrinter.printLineList(menu.getMenuLines());
                String s = sc.nextLine();
                int usersChoice = Integer.parseInt(s);
                switch (usersChoice) {
                    case CHOICE_SUM_MATRICES: {
                        ConsolePrinter.printLine("Chosen operation is SUM MATRICES.");
                        makeMathOperation(usersChoice, new EvaluatorSum());
                    }
                    break;
                    case CHOICE_SUBTRACT_MATRICES: {
                        ConsolePrinter.printLine("Chosen operation is SUBTRACT MATRICES.");
                        makeMathOperation(usersChoice, new EvaluatorSubtract());
                    }
                    break;
                    case CHOICE_MULT_MATRICES: {
                        ConsolePrinter.printLine("Chosen operation is MULTIPLY MATRICES.");
                        makeMathOperation(usersChoice, new EvaluatorMultiply());
                    }
                    break;
                    case CHOICE_MULT_NUMBER: {
                        ConsolePrinter.printLine("Chosen operation is MULTIPLY MATRIX ON NUMBER.");
                        makeMathOperation(usersChoice, new EvaluatorMultiplyOnNumber());
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

    // makes chosen by user math operation: invokes input of arguments and then chosen operation
    private static void makeMathOperation(int usersChoice, Evaluator evaluator) {
        Matrix matrix1 = InputMatrix.inputMatrixData();
        ConsolePrinter.printLine("Inputted matrix #1:");
        ConsolePrinter.printLineList(OutputMatrix.matrixToStringList(matrix1));

        Matrix matrix2 = null;
        double number = 0;
        if (evaluator.getClass() == EvaluatorMultiplyOnNumber.class) {
            number = InputMatrix.inputDouble("Input double multiplier:");
            evaluator.setMultiplier(number);
        }
        else {
            matrix2 = InputMatrix.inputMatrixData();
            ConsolePrinter.printLine("Inputted matrix #2:");
            ConsolePrinter.printLineList(OutputMatrix.matrixToStringList(matrix2));
        }

        try {

            Matrix result = matrixCalc.makeOperation(evaluator, matrix1, matrix2);
            ConsolePrinter.printLine("The result is:");
            ConsolePrinter.printLineList(OutputMatrix.matrixToStringList(result));
        }
        catch (Exception e) {
            ConsolePrinter.printLine(e.getMessage());
        }
        ConsolePrinter.printLine("");
    }
}
