package ua.goit.group09.coreProject;

import java.util.Arrays;

/**
 * Class with matrix data
 */
public class MatrixData {
    /* number of lines in matrix */
    private int lines;
    /* number of columns in matrix */
    private int columns;
    /* 2-dimension array with matrix elements */
    private double[][] array;

    /* Default constructor */
    public MatrixData() {
    }

    /* Constructor by numbers of lines & columns */
    public MatrixData(int lines, int columns) {
        this();
        this.lines = lines;
        this.columns = columns;
    }

    /* Full constructor */
    public MatrixData(int lines, int columns, double[][] array) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        MatrixData that = (MatrixData) obj;

        if (lines != that.lines) return false;
        if (columns != that.columns) return false;
        return Arrays.deepEquals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = lines;
        result = 31 * result + columns;
        result = 31 * result + Arrays.deepHashCode(array);
        return result;
    }
}
