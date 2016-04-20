package ua.goit.group09.coreProject.data;

import java.util.Arrays;

/**
 * Class with matrix immutable data
 */
public final class Matrix {
    /* permissible error of the comparison */
    private static final double DELTA = 10E-9;

    /* Two-dimension array with matrix elements */
    private final double[][] array;

    /* Constructor with given array */
    public Matrix(double[][] array) {
        this.array = array.clone();
    }

    /* Constructor for defencive copy */
    public Matrix(Matrix matrix) {
        this.array = matrix.array;
    }

    public double[][] getArray() {
        return array.clone();
    }

    public int getLines() {
        return getArray().length;
    }

    public int getColumns() {
        return getArray()[0].length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Matrix that = (Matrix) obj;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (Math.abs(array[i][j] - that.array[i][j]) > DELTA) return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(array);
    }
}
