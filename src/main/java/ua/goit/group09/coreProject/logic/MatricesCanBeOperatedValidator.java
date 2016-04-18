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
     * Checks if given matrices can be added, than invokes method sum from decorated class
     * @param addend1       addend matrix #1
     * @param addend2       addend matrix #2
     * @return              result of summation
     */
    @Override
    public Matrix sum(Matrix addend1, Matrix addend2) {
        if (isImpossibleToAddSubtrat(addend1, addend2)) {
            throw new IllegalArgumentException
                    ("Added matrices have different number of lines or columns to sum!");
        }
        return this.origin.sum(addend1, addend2);
    }

    /**
     * Checks if given matrices can be subtracted, than invokes method subtract from decorated class
     * @param minuend       minuend matrix
     * @param subtrahend    subtrahend matrix
     * @return              result of subtract
     */
    @Override
    public Matrix subtract(Matrix minuend, Matrix subtrahend) {
        if (isImpossibleToAddSubtrat(minuend, subtrahend)) {
            throw new IllegalArgumentException
                    ("Added matrices have different number of lines or columns to subtract!");
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
        if (isImpossibleToMultiply(multiplier1, multiplier2)) {
            throw new IllegalArgumentException
                    ("Second multiplied matrix has improper number of lines to multiply!");
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
        return this.origin.multiply(number, multiplier);
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
