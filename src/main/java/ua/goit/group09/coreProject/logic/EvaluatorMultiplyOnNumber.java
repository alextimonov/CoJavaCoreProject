package ua.goit.group09.coreProject.logic;

import ua.goit.group09.coreProject.data.Matrix;

/**
 * Class with realisation of evaluation the multiplication of double number and matrix
 */
public class EvaluatorMultiplyOnNumber implements Evaluator {

    private double multiplier;

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    /**
     * finds the multiplication of double number and matrix
     * @param mathOperation       type of math operation with double number to multiply
     * @param matrix1             matrix to multiply
     * @param matrix2             unused in this case parameter
     * @return                    result of multiplication
     */
    @Override
    public Matrix evaluate(MathOperation mathOperation, Matrix matrix1, Matrix matrix2) {
        double[][] resultArray = new double[matrix1.getLines()][matrix1.getColumns()];
        for (int i = 0; i < matrix1.getLines(); i++) {
            for (int j = 0; j < matrix1.getColumns(); j++) {
                resultArray[i][j] = mathOperation.getDoubleMultiplier() * matrix1.getArray()[i][j];
            }
        }
        return new Matrix(resultArray);
    }
}
