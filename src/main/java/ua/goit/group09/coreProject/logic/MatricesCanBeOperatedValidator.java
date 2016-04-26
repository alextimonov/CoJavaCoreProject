package ua.goit.group09.coreProject.logic;

import ua.goit.group09.coreProject.data.Matrix;
import ua.goit.group09.coreProject.exceptions.*;

/**
 * Class-decorator for the class MatrixCalc, checks if given matrices can be operated
 * in depending on given type of math operation
 */
public class MatricesCanBeOperatedValidator implements MatrixCalc {

    /* decorated object */
    private final MatrixCalc origin;

    // Constructor for decorator
    public MatricesCanBeOperatedValidator(MatrixCalc origin) {
        this.origin = origin;
    }

    /**
     * checks number of lines and columns of given matrices to determine that they can be operated,
     * than invokes the same method of super class to make math operation
     * @param evaluator         type of Evaluator
     * @param matrix1           first matrix to be operated
     * @param matrix2           second matrix to be operated (if it's needed to given type of math operation)
     * @return                  result of given operation
     */
    @Override
    public Matrix makeOperation(Evaluator evaluator, Matrix matrix1, Matrix matrix2) {
        if (evaluator.getClass() == EvaluatorSum.class || evaluator.getClass() == EvaluatorSubtract.class) {
            if (isImpossibleToAddSubtrat(matrix1, matrix2)) {
                throw new AddSubtractImpossibleException
                        ("Matrices have different number of lines or columns to sum or subtract!");
            }
        }
        if (evaluator.getClass() == EvaluatorMultiply.class) {
            if (isImpossibleToMultiply(matrix1, matrix2)) {
                throw new MultiplyImpossibleException
                        ("Second multiplied matrix has improper number of lines to multiply!");
            }
        }
        return this.origin.makeOperation(evaluator, matrix1, matrix2);
    }

   // checks if given matrix can be added or subtracted
    private boolean isImpossibleToAddSubtrat(Matrix matrix1, Matrix matrix2) {
        return matrix1.getLines() != matrix2.getLines() ||
                matrix1.getColumns() != matrix2.getColumns();
    }

    // checks if it's possible to multiply two matrices
    private boolean isImpossibleToMultiply(Matrix multiplier1, Matrix multiplier2) {
        return multiplier1.getColumns() != multiplier2.getLines();
    }
}
