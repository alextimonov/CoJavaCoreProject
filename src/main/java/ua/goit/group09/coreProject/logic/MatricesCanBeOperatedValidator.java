package ua.goit.group09.coreProject.logic;

import ua.goit.group09.coreProject.data.Matrix;

/**
 * Created by Alex on 16.04.2016.
 */
public class MatricesCanBeOperatedValidator implements MatrixCalc {

    /* decorated object */
    private final MatrixCalc origin;

    // Constructor for decorator
    public MatricesCanBeOperatedValidator(MatrixCalc origin) {
        this.origin = origin;
    }

    /**
     * checks number of lines and columns of given matrices to determine that they can be operated,
     * than invokes the same method of super class to make math operation
     * @param mathOperation     type of math operation (sum, subtract, multiply)
     * @param matrix1           first matrix to be operated
     * @param matrix2           second matrix to be operated (if it's needed to given type of math operation)
     * @param number            number to be operated (if it's needed to given type of math operation)
     * @return                  result of given operation
     */
    @Override
    public Matrix makeOperation(MathOperation mathOperation, Matrix matrix1, Matrix matrix2, double number) {
        switch (mathOperation) {
            case SUM_MATRICES:
            case SUBTRACT_MATRICES: {
                if (isImpossibleToAddSubtrat(matrix1, matrix2)) {
                    throw new IllegalArgumentException
                            ("Added matrices have different number of lines or columns to sum!");
                }
            }
            break;
            case MULTIPLY_MATRICES: {
                if (isImpossibleToMultiply(matrix1, matrix2)) {
                    throw new IllegalArgumentException
                            ("Second multiplied matrix has improper number of lines to multiply!");
                }
            }
            break;
        }
        return this.origin.makeOperation(mathOperation, matrix1, matrix2, number);
    }

   // checks if given matrix can be added or subtracted
    private boolean isImpossibleToAddSubtrat(Matrix matrix1, Matrix matrix2) {
        return matrix1.getLines() != matrix2.getLines() ||
                matrix1.getColumns() != matrix2.getColumns();
    }

    // checks if it's possible to multiply two matrices
    private boolean isImpossibleToMultiply(Matrix multiplier1, Matrix multiplier2) {
        return multiplier1.getColumns() != multiplier2.getLines();
    }
}
