package ua.goit.group09.coreProject.data;

/**
 * Container for class Matrix to provide defencive copies
 */
public class MatrixContainer {
    private Matrix matrix;

    public MatrixContainer(Matrix matrix) {
        this.matrix = new Matrix(matrix);
    }

    public Matrix getMatrix() {
        return new Matrix(matrix);
    }
}