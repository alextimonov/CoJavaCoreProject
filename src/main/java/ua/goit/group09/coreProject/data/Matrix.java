package ua.goit.group09.coreProject.data;

import java.util.Arrays;

/**
 * Class with matrix data
 */
public class Matrix {
    /* permissible error of the comparison */
    public static final double DELTA = 10E-9;
    /* 2-dimension array with matrix elements */
    private final double[][] array;

    /* Constructor with given array */
    public Matrix(double[][] array) {
        this.array = array;
    }

    /* ================ Getters & Setters =================== */

    public int getLines() {
        return array.length;
    }

        public int getColumns() {
        return array[0].length;
    }

    public double[][] getArray() {
        return array;
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
