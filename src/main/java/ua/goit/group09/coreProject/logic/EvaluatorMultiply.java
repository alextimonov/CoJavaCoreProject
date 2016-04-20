package ua.goit.group09.coreProject.logic;

import ua.goit.group09.coreProject.data.Matrix;

/**
 * Created by Alex on 20.04.2016.
 */
public class EvaluatorMultiply implements Evaluator {

    /**
     * finds the multiplication of two matrices
     * @param mathOperation       type of math operation
     * @param matrix1             multiplied matrix #1
     * @param matrix2             multiplied matrix #2
     * @return result of multiplication
     */
    @Override
    public Matrix evaluate(MathOperation mathOperation, Matrix matrix1, Matrix matrix2) {
        double[][] resultArray = new double[matrix1.getLines()][matrix2.getColumns()];
        for (int i = 0; i < matrix1.getLines(); i++) {
            for (int j = 0; j < matrix2.getColumns(); j++) {
                resultArray[i][j] = 0;
                for (int k = 0; k < matrix1.getColumns(); k++) {
                    resultArray[i][j] += matrix1.getArray()[i][k] * matrix2.getArray()[k][j];
                }
            }
        }
        return new Matrix(resultArray);
    }
}
