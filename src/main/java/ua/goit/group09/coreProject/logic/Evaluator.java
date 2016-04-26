package ua.goit.group09.coreProject.logic;

import ua.goit.group09.coreProject.data.Matrix;

/**
 * Interface with method of evaluation different operations with matrices
 */
public abstract class Evaluator {
    protected double multiplier;

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    Matrix evaluate(Matrix matrix1, Matrix matrix2) {
        return new Matrix(new double[][] {{}});
    }
}
