package ua.goit.group09.coreProject.logic;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.goit.group09.coreProject.data.Matrix;
import ua.goit.group09.coreProject.exceptions.MatrixHasDifferentNColumnsException;
import ua.goit.group09.coreProject.exceptions.MatrixNullPointerException;

import static org.junit.Assert.*;

/**
 * Testing class for method multiply of class MatrixCalcDefault
 */
public class MatrixNumberMultiplyTest {
    private static MatrixCalc matrixCalc =
            (new MatricesValidator
                    (new MatricesCanBeOperatedValidator
                            (new MatrixCalcDefault())));
    MathOperation multiplyNumber = MathOperation.MULTIPLY_NUMBER_AND_MATRIX;
    Evaluator evaluator = new EvaluatorMultiplyOnNumber();

    @Test
    public void testMultiplyNormal_1() {
        double[][] arr1 = {{2, 3}, {4, 2}};
        Matrix matrix = new Matrix(arr1);

        multiplyNumber.setDoubleMultiplier(1.0);

        Matrix expected = matrix;
        Matrix actual = matrixCalc.makeOperation(multiplyNumber, evaluator, matrix, null);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyNormal_2() {
        double[][] arr1 = {{1, 2}, {3, 4}};
        Matrix matrix = new Matrix(arr1);

        multiplyNumber.setDoubleMultiplier(4.0);

        double[][] arr = {{4, 8}, {12, 16}};
        Matrix expected =  new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(multiplyNumber, evaluator, matrix, null);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyNormal_3() {
        double[][] arr1 = {{1.75, 2.25}, {3.5, 4.0}, {5.6, 6.4}};
        Matrix matrix = new Matrix(arr1);

        multiplyNumber.setDoubleMultiplier(5.25);

        double[][] arr = {{9.1875, 11.8125}, {18.375, 21.0}, {29.4, 33.6}};
        Matrix expected =  new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(multiplyNumber, evaluator, matrix, null);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyNormal_4() {
        double[][] arr1 = {{1}, {1}, {1}};
        Matrix matrix = new Matrix(arr1);

        multiplyNumber.setDoubleMultiplier(7.0);

        double[][] arr = {{7.0}, {7.0}, {7.0}};
        Matrix expected =  new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(multiplyNumber, evaluator, matrix, null);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyBorder_1() {
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 0}};
        Matrix matrix = new Matrix(arr1);

        multiplyNumber.setDoubleMultiplier(0.0);

        double[][] arr = {{0, 0}, {0, 0}, {0, 0}};
        Matrix expected =  new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(multiplyNumber, evaluator, matrix, null);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyBorder_2() {
        double[][] arr1 = {{0.0}};
        Matrix matrix = new Matrix(arr1);

        multiplyNumber.setDoubleMultiplier(5.0);

        double[][] arr = {{0.0}};
        Matrix expected =  new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(multiplyNumber, evaluator, matrix, null);
        assertEquals(expected, actual);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testMultiplyDifferentNColumns() {
        double[][] arr1 = {{-2, 3, 0}, {7, 3}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{3, -3, 4}, {-5, 2, -4}};
        Matrix matrix2 = new Matrix(arr2);

        expectedException.expect(MatrixHasDifferentNColumnsException.class);
        matrixCalc.makeOperation(multiplyNumber, evaluator, matrix1, matrix2);
    }

    @Test
    public void testMultiplyNullMatrix_1() {
        Matrix matrix = null;
        multiplyNumber.setDoubleMultiplier(5.0);

        expectedException.expect(MatrixNullPointerException.class);
        matrixCalc.makeOperation(multiplyNumber, evaluator, matrix, null);
    }
}