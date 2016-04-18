package ua.goit.group09.coreProject.logic;

import ua.goit.group09.coreProject.data.Matrix;

/**
 * Class - decorator for the class MatrixCalc, checks if given matrices are valid
 */
public class MatricesValidator implements MatrixCalc {

    /* decorated object */
    private final MatrixCalc origin;

    // Constructor for decorator
    public MatricesValidator(MatrixCalc matrixCalc) {
        this.origin = matrixCalc;
    }

    /**
     * Checks if given matrices with data are valid, than invokes method sum from decorated class
     * @param addend1       addend matrix #1
     * @param addend2       addend matrix #2
     * @return              result of summation
     */
    @Override
    public Matrix sum(Matrix addend1, Matrix addend2) {
        if (isNotValid(addend1) || isNotValid(addend2)) {
            throw new IllegalArgumentException("Matrix has less than one line or column!");
        }
        return this.origin.sum(addend1, addend2);
    }

    /**
     * Checks if given matrices with data are valid, than invokes method subtract from decorated class
     * @param minuend       minuend matrix
     * @param subtrahend    subtrahend matrix
     * @return              result of subtract
     */
    @Override
    public Matrix subtract(Matrix minuend, Matrix subtrahend) {
        if (isNotValid(minuend) || isNotValid(subtrahend)) {
            throw new IllegalArgumentException("Matrix has less than one line or column!");
        }
        return this.origin.subtract(minuend, subtrahend);
    }

    /**
     * Checks if given matrices with data are valid, than invokes method multiply from decorated class
     * @param multiplier1       multiplied matrix #1
     * @param multiplier2       multiplied matrix #2
     * @return                  result of multiplication
     */
    @Override
    public Matrix multiply(Matrix multiplier1, Matrix multiplier2) {
        if (isNotValid(multiplier1) || isNotValid(multiplier2)) {
            throw new IllegalArgumentException("Matrix has less than one line or column!");
        }
        return this.origin.multiply(multiplier1, multiplier2);
    }

    /**
     * Checks if given matriх with data is valid, than invokes method multiply from decorated class
     * @param number
     * @param multiplier
     * @return
     */
    @Override
    public Matrix multiply(double number, Matrix multiplier) {
        if (isNotValid(multiplier)) {
            throw new IllegalArgumentException("Matrix has less than one line or column!");
        }
        return this.origin.multiply(number, multiplier);
    }

    private static boolean isNotValid(Matrix matrix) {
        return matrix.getLines() < 1 || matrix.getColumns() < 1;
    }
}
