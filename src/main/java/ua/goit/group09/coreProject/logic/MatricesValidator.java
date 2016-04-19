package ua.goit.group09.coreProject.logic;

import ua.goit.group09.coreProject.data.Matrix;
import ua.goit.group09.coreProject.exceptions.*;

/**
 * Class-decorator for the class MatrixCalc, checks if given matrices are valid
 */
public class MatricesValidator implements MatrixCalc {

    /* decorated object */
    private final MatrixCalc origin;

    // Constructor for decorator
    public MatricesValidator(MatrixCalc matrixCalc) {
        this.origin = matrixCalc;
    }

    /**
     * makes validation of given matrices, than invokes the same method of super class to make math operation
     * chosen math operation with to given matrices or matrix #1 and number
     * @param mathOperation     type of math operation (sum, subtract, multiply)
     * @param matrix1           first matrix to be operated
     * @param matrix2           second matrix to be operated (if it's needed to given type of math operation)
     * @return                  result of given operation
     */
    @Override
    public Matrix makeOperation(MathOperation mathOperation, Matrix matrix1, Matrix matrix2) {
        makeValidation(matrix1);
        if (isNeedToCheckSecondMatrix(mathOperation))
            makeValidation(matrix2);
        return this.origin.makeOperation(mathOperation, matrix1, matrix2);
    }

    private void makeValidation(Matrix matrix) {
        if (matrix == null) {
            throw new MatrixNullPointerException("Matrix object points to null!");
        }
        /*if (isNotValid(matrix)) {
            throw new LessThanOneLineColumnException("Matrix has less than one line or column!");
        }
        if (hasDifferentNLinesOrColumns(matrix)) {
            throw new WrongNLinesColumnsException("Matrix has different number of lines (columns) in field and array!");
        }*/
    }

    // checks if operation will be done with two matrices and it's necessary to makeValidation second matrix
    private static boolean isNeedToCheckSecondMatrix(MathOperation mathOperation) {
        return mathOperation != MathOperation.MULTIPLY_NUMBER_AND_MATRIX;
    }

    /*// checks if given matrix has less than one line or column
    private static boolean isNotValid(Matrix matrix) {
        return matrix.getLines() < 1 || matrix.getColumns() < 1;
    }*/

    /*// checks if given matrix has different number of lines (columns) in field lines(columns) and array
    private static boolean hasDifferentNLinesOrColumns(Matrix matrix) {
        return matrix.getLines() != matrix.getArray().length || matrix.getColumns() != matrix.getArray()[0].length;
    }*/
}
