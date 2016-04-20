package ua.goit.group09.coreProject.logic;

import ua.goit.group09.coreProject.data.Matrix;

/**
 * Class with realisation of evaluation the difference of two matrices
 */
public class EvaluatorSubtract implements Evaluator {

    /**
     * finds the difference of two matrices
     * @param mathOperation       type of math operation
     * @param matrix1    minuend matrix
     * @param matrix2    subtrahend matrix
     * @return result of subtract
     */
    @Override
    public Matrix evaluate(MathOperation mathOperation, Matrix matrix1, Matrix matrix2) {
        double[][] resultArray = new double[matrix1.getLines()][matrix1.getColumns()];
        for (int i = 0; i < matrix1.getLines(); i++) {
            for (int j = 0; j < matrix1.getColumns(); j++) {
                resultArray[i][j] = matrix1.getArray()[i][j] - matrix2.getArray()[i][j];
            }
        }
        return new Matrix(resultArray);
    }
}
