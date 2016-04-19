package ua.goit.group09.coreProject.logic;

import ua.goit.group09.coreProject.data.Matrix;

/**
 * Class with realisation of matrix operations
 */
public class MatrixCalcDefault implements MatrixCalc {

    /**
     * makes given math operation with to given matrices or matrix #1 and number
     * @param mathOperation     type of math operation (sum, subtract, multiply)
     * @param matrix1           first matrix to be operated
     * @param matrix2           second matrix to be operated (if it's needed to given type of math operation)
     * @param number            number to be operated (if it's needed to given type of math operation)
     * @return                  result of given operation
     */
    @Override
    public Matrix makeOperation(MathOperation mathOperation, Matrix matrix1, Matrix matrix2, double number) {
        Matrix result = null;
        switch (mathOperation) {
            case SUM_MATRICES: {
                result = sum(matrix1, matrix2);
            }
            break;
            case SUBTRACT_MATRICES: {
                result = subtract(matrix1, matrix2);
            }
            break;
            case MULTIPLY_MATRICES: {
                result = multiply(matrix1, matrix2);
            }
            break;
            case MULTIPLY_NUMBER_AND_MATRIX: {
                result = multiply(number, matrix1);
            }
        }
        return result;
    }

    /**
     * finds the sum of two matrices
     * @param addend1 addend matrix #1
     * @param addend2 addend matrix #2
     * @return result of summation
     */
    public Matrix sum(Matrix addend1, Matrix addend2) {
        double[][] resultArray = new double[addend1.getLines()][addend1.getColumns()];
        for (int i = 0; i < addend1.getLines(); i++) {
            for (int j = 0; j < addend1.getColumns(); j++) {
                resultArray[i][j] = addend1.getArray()[i][j] + addend2.getArray()[i][j];
            }
        }
        return new Matrix(resultArray);
    }

    /**
     * finds the difference of two matrices
     * @param minuend    minuend matrix
     * @param subtrahend subtrahend matrix
     * @return result of subtract
     */
    public Matrix subtract(Matrix minuend, Matrix subtrahend) {
        double[][] resultArray = new double[minuend.getLines()][minuend.getColumns()];
        for (int i = 0; i < minuend.getLines(); i++) {
            for (int j = 0; j < minuend.getColumns(); j++) {
                resultArray[i][j] = minuend.getArray()[i][j] - subtrahend.getArray()[i][j];
            }
        }
        return new Matrix(resultArray);
    }

    /**
     * finds the multiplication of two matrices
     * @param multiplier1 multiplied matrix #1
     * @param multiplier2 multiplied matrix #2
     * @return result of multiplication
     */
    public Matrix multiply(Matrix multiplier1, Matrix multiplier2) {
        double[][] resultArray = new double[multiplier1.getLines()][multiplier2.getColumns()];
        for (int i = 0; i < multiplier1.getLines(); i++) {
            for (int j = 0; j < multiplier2.getColumns(); j++) {
                resultArray[i][j] = 0;
                for (int k = 0; k < multiplier1.getColumns(); k++) {
                    resultArray[i][j] += multiplier1.getArray()[i][k] * multiplier2.getArray()[k][j];
                }
            }
        }
        return new Matrix(resultArray);
    }

    /**
     * finds the multiplication of double number and matrix
     * @param number
     * @param multiplier
     * @return
     */
    public Matrix multiply(double number, Matrix multiplier) {
        double[][] resultArray = new double[multiplier.getLines()][multiplier.getColumns()];
        for (int i = 0; i < multiplier.getLines(); i++) {
            for (int j = 0; j < multiplier.getColumns(); j++) {
                resultArray[i][j] = number * multiplier.getArray()[i][j];
            }
        }
        return new Matrix(resultArray);
    }
}
