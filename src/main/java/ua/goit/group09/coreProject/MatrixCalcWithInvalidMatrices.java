package ua.goit.group09.coreProject;

/**
 * Class - decorator for the class MatrixCalc, checks if given matrices are valid
 */
public class MatrixCalcWithInvalidMatrices implements MatrixCalc {

    /* decorated object */
    private final MatrixCalc origin;

    // Constructor for decorator
    MatrixCalcWithInvalidMatrices(MatrixCalc matrixCalc) {
        this.origin = matrixCalc;
    }

    /**
     * Checks if given matrices with data are valid, than invokes method add from decorated class
     * @param addend1       addend matrix #1
     * @param addend2       addend matrix #2
     * @return              result of summation
     */
    @Override
    public MatrixData add(MatrixData addend1, MatrixData addend2) {
        if (isNotValid(addend1) || isNotValid(addend2)) {
            throw new IllegalArgumentException("Matrix has less than one line or column!");
        }
        return this.origin.add(addend1, addend2);
    }

    /**
     * Checks if given matrices with data are valid, than invokes method subtract from decorated class
     * @param minuend       minuend matrix
     * @param subtrahend    subtrahend matrix
     * @return              result of subtract
     */
    @Override
    public MatrixData subtract(MatrixData minuend, MatrixData subtrahend) {
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
    public MatrixData multiply(MatrixData multiplier1, MatrixData multiplier2) {
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
    public MatrixData multiply(double number, MatrixData multiplier) {
        if (isNotValid(multiplier)) {
            throw new IllegalArgumentException("Matrix has less than one line or column!");
        }
        return this.origin.multiply(number, multiplier);
    }

    private static boolean isNotValid(MatrixData matrixData) {
        return matrixData.getLines() < 1 || matrixData.getColumns() < 1;
    }
}
