package ua.goit.group09.coreProject;

import java.util.Arrays;

/**
 * Provides 2-dimension matrix and operations with another matrix
 */
public class Matrix {
    /* number of lines in matrix */
    private int lines;
    /* number of columns in matrix */
    private int columns;
    /* 2-dimension array with matrix elements */
    private double[][] array;

    /* Default constructor */
    public Matrix() {
    }

    /* Constructor by numbers of lines & columns */
    public Matrix(int lines, int columns) {
        this();
        this.lines = lines;
        this.columns = columns;
        checkIfMatrixValid(this);
        array = new double[lines][columns];
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = 0;
            }
        }
    }

    /* Full constructor */
    public Matrix(int lines, int columns, double[][] array) {
        this.lines = lines;
        this.columns = columns;
        this.array = array;
    }

    /* ================ Getters & Setters =================== */

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public double[][] getArray() {
        return array;
    }

    public void setArray(double[][] array) {
        this.array = array;
    }

    /**
     * adds given matrix to this
     * @param addend            given addend matrix
     * @return                  result of adding
     */
    public Matrix add(Matrix addend) {
        checkIfMatrixValid(addend);
        checkIfMatrixValidToAddOrSubtract(addend);
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] += addend.array[i][j];
            }
        }
        return this;
    }

    /**
     * adds given matrix to this
     * @param deducted          given addend matrix
     * @return                  result of adding
     */

    public Matrix subtract(Matrix deducted) {
        checkIfMatrixValid(deducted);
        checkIfMatrixValidToAddOrSubtract(deducted);
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] -= deducted.array[i][j];
            }
        }
        return this;
    }

    /**
     * multiplies two matrix: this and given
     * @param multiplier        given multiplier matrix
     * @return                  result of multiply
     */
    public Matrix multiply(Matrix multiplier) {
        checkIfMatrixValid(multiplier);
        checkIfMatrixValidToMultiply(multiplier);
        Matrix result = new Matrix(lines, multiplier.getColumns());
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < multiplier.getColumns(); j++) {
                result.array[i][j] = 0;
                for (int k = 0; k < columns; k++) {
                    result.array[i][j] += array[i][k] * multiplier.array[k][j];
                }
            }
        }
        return result;
    }

    // checks if matrix has number of lines or columns less than one
    private void checkIfMatrixValid(Matrix multiplier) {
        if (multiplier.getLines() <= 0 || multiplier.getColumns() <= 0) {
            throw new IllegalArgumentException("Matrix has less than one line or column!");
        }
    }

    // checks if given matrix can be added or subtracted to this matrix
    private void checkIfMatrixValidToAddOrSubtract(Matrix givenMatrix) {
        if (lines != givenMatrix.getLines() || columns != givenMatrix.getColumns()) {
            throw new IllegalArgumentException
                    ("Added(subtracted) matrices have different number of lines or columns to add(subtract)!");
        }
    }

    // checks if it's possible to multiply two matrix: this and given
    private void checkIfMatrixValidToMultiply(Matrix multiplier) {
        if (columns != multiplier.getLines()) {
            throw new IllegalArgumentException("Second (multiplied) matrix has improper number of lines to multiply!");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Matrix matrix = (Matrix) obj;

        if (lines != matrix.lines) return false;
        if (columns != matrix.columns) return false;
        return Arrays.deepEquals(array, matrix.array);

    }

    @Override
    public int hashCode() {
        int result = lines;
        result = 31 * result + columns;
        result = 31 * result + Arrays.deepHashCode(array);
        return result;
    }

    // TODO
    public Matrix multNumber(double number) {
        return this;
    }
}