package ua.goit.group09.coreProject.logic;

import ua.goit.group09.coreProject.data.Matrix;

/**
 * Class with realisation of evaluation the sum of two matrices
 */
public class EvaluatorSum extends Evaluator {

    /**
     * finds the sum of two matrices
     * @param matrix1 addend matrix #1
     * @param matrix2 addend matrix #2
     * @return result of summation
     */
    @Override
    public Matrix evaluate(Matrix matrix1, Matrix matrix2) {
        double[][] resultArray = new double[matrix1.getLines()][matrix1.getColumns()];
        for (int i = 0; i < matrix1.getLines(); i++) {
            for (int j = 0; j < matrix1.getColumns(); j++) {
                resultArray[i][j] = matrix1.getArray()[i][j] + matrix2.getArray()[i][j];
            }
        }
        return new Matrix(resultArray);
    }
}
