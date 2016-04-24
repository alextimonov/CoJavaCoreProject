package ua.goit.group09.coreProject.logic;

import ua.goit.group09.coreProject.data.Matrix;
import java.util.concurrent.RecursiveTask;

/**
 * A class that is used to evaluate elements of matrix that is the multiplication of two matrices
 */
public class ForkJoinMultiplier extends RecursiveTask<Double> {
    private Matrix matrix1;
    private Matrix matrix2;
    int line;
    int column;

    /**
     * Constructor of forked task of finding element
     */
    public ForkJoinMultiplier(Matrix matrix1, Matrix matrix2, int line, int column) {
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.line = line;
        this.column = column;
    }

    /**
     * finds element of matrix that is the result of multiplication of two given matrices,
     * @return      value of element of result matrix with index [line][column]
     */
    @Override
    protected Double compute() {
        double sum = 0;
        for (int k = 0; k < matrix1.getColumns(); k++) {
            sum += matrix1.getArray()[line][k] * matrix2.getArray()[k][column];
        }
        return sum;
    }
}
