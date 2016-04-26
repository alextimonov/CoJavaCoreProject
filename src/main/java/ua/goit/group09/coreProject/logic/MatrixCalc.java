package ua.goit.group09.coreProject.logic;

import ua.goit.group09.coreProject.data.Matrix;

/**
 * Interface with matrix operations
 */
public interface MatrixCalc {
    /**
     * makes given math operation with to given matrices or matrix #1 and number
     * @param mathOperation     type of math operation (sum, subtract, multiply)
     * @param evaluator
     *@param matrix1           first matrix to be operated
     * @param matrix2           second matrix to be operated (if it's needed to given type of math operation)   @return                  result of given operation
     */
    Matrix makeOperation(MathOperation mathOperation, Evaluator evaluator, Matrix matrix1, Matrix matrix2);
}