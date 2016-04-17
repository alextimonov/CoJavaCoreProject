package ua.goit.group09.coreProject.logic;

import ua.goit.group09.coreProject.data.MatrixData;

/**
 * Created by Alex on 16.04.2016.
 */
public class MatrixCalcProperMatricesValidator implements MatrixCalc {

    /* decorated object */
    private final MatrixCalc origin;

    // Constructor for decorator
    public MatrixCalcProperMatricesValidator(MatrixCalc origin) {
        this.origin = origin;
    }

    /**
     * Checks if given matrices can be added, than invokes method add from decorated class
     * @param addend1       addend matrix #1
     * @param addend2       addend matrix #2
     * @return              result of summation
     */
    @Override
    public MatrixData add(MatrixData addend1, MatrixData addend2) {
        if (isImpossibleToAddSubtrat(addend1, addend2)) {
            throw new IllegalArgumentException
                    ("Added matrices have different number of lines or columns to add!");
        }
        return this.origin.add(addend1, addend2);
    }

    /**
     * Checks if given matrices can be subtracted, than invokes method subtract from decorated class
     * @param minuend       minuend matrix
     * @param subtrahend    subtrahend matrix
     * @return              result of subtract
     */
    @Override
    public MatrixData subtract(MatrixData minuend, MatrixData subtrahend) {
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
    public MatrixData multiply(MatrixData multiplier1, MatrixData multiplier2) {
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
    public MatrixData multiply(double number, MatrixData multiplier) {
        return this.origin.multiply(number, multiplier);
    }

    // checks if given matrix can be added or subtracted
    private boolean isImpossibleToAddSubtrat(MatrixData matrixData1, MatrixData matrixData2) {
        return matrixData1.getLines() != matrixData2.getLines() ||
                matrixData1.getColumns() != matrixData2.getColumns();
    }

    // checks if it's possible to multiply two matrices
    private boolean isImpossibleToMultiply(MatrixData multiplier1, MatrixData multiplier2) {
        return multiplier1.getColumns() != multiplier2.getLines();
    }
}
