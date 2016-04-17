package ua.goit.group09.coreProject;

/**
 * Class with matrix operators
 */
public class MatrixCalcDefault implements MatrixCalc {
    /**
     * finds the sum of two matrices
     * @param addend1       addend matrix #1
     * @param addend2       addend matrix #2
     * @return              result of summation
     */
    @Override
    public MatrixData add(MatrixData addend1, MatrixData addend2) {
        MatrixData resultMatrix = new MatrixData(addend1.getLines(), addend1.getColumns());
        double[][] resultArray = new double[addend1.getLines()][addend1.getColumns()];
        for (int i = 0; i < addend1.getLines(); i++) {
            for (int j = 0; j < addend1.getColumns(); j++) {
                resultArray[i][j] = addend1.getArray()[i][j] + addend2.getArray()[i][j];
            }
        }
        resultMatrix.setArray(resultArray);
        return resultMatrix;
    }

    /**
     * finds the difference of two matrices
     * @param minuend       minuend matrix
     * @param subtrahend    subtrahend matrix
     * @return              result of subtract
     */
    @Override
    public MatrixData subtract(MatrixData minuend, MatrixData subtrahend) {
        MatrixData resultMatrix = new MatrixData(minuend.getLines(), minuend.getColumns());
        double[][] resultArray = new double[minuend.getLines()][minuend.getColumns()];
        for (int i = 0; i < minuend.getLines(); i++) {
            for (int j = 0; j < minuend.getColumns(); j++) {
                resultArray[i][j] = minuend.getArray()[i][j] - subtrahend.getArray()[i][j];
            }
        }
        resultMatrix.setArray(resultArray);
        return resultMatrix;
    }

    /**
     * finds the multiplication of two matrices
     * @param multiplier1       multiplied matrix #1
     * @param multiplier2       multiplied matrix #2
     * @return                  result of multiplication
     */
    @Override
    public MatrixData multiply(MatrixData multiplier1, MatrixData multiplier2) {
        MatrixData resultMatrix = new MatrixData(multiplier1.getLines(), multiplier2.getColumns());
        double[][] resultArray = new double[multiplier1.getLines()][multiplier2.getColumns()];
        for (int i = 0; i < multiplier1.getLines(); i++) {
            for (int j = 0; j < multiplier2.getColumns(); j++) {
                resultArray[i][j] = 0;
                for (int k = 0; k < multiplier1.getColumns(); k++) {
                    resultArray[i][j] += multiplier1.getArray()[i][k] * multiplier2.getArray()[k][j];
                }
            }
        }
        resultMatrix.setArray(resultArray);
        return resultMatrix;
    }

    /**
     * finds the multiplication of double number and matrix
     * @param number
     * @param multiplier
     * @return
     */
    @Override
    public MatrixData multiply(double number, MatrixData multiplier) {
        // TODO
        return multiplier;
    }
}
