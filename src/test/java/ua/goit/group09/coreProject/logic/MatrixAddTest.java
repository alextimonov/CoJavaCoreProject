package ua.goit.group09.coreProject.logic;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.goit.group09.coreProject.data.Matrix;
import ua.goit.group09.coreProject.exceptions.*;

import static org.junit.Assert.*;

/**
 * Testing class for method multiply of class MatrixCalcDefault
 */
public class MatrixAddTest {
    private static MatrixCalc matrixCalc =
            (new MatricesValidator
                    (new MatricesCanBeOperatedValidator
                            (new MatrixCalcDefault())));
    Evaluator evaluator = new EvaluatorSum();

    @Test
    public void testAddNormal_1() {
        double[][] arr1 = {{1, 2}, {3, 4}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{0, 0}, {0, 0}};
        Matrix matrix2 = new Matrix(arr2);

        Matrix expected = matrix1;
        Matrix actual = matrixCalc.makeOperation(evaluator, matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddNormal_2() {
        double[][] arr1 = {{1, 2}, {3, 4}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{5, 6}, {7, 8}};
        Matrix matrix2 = new Matrix(arr2);

        double[][] arr = {{6, 8}, {10, 12}};
        Matrix expected =  new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(evaluator, matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddNormal_3() {
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{7, 6}, {5, 4}, {3, 2}};
        Matrix matrix2 = new Matrix(arr2);

        double[][] arr = {{8, 8}, {8, 8}, {8, 8}};
        Matrix expected =  new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(evaluator, matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddNormal_4() {
        double[][] arr1 = {{7, 5, 12}};
        Matrix matrix1 = new Matrix(arr1);;

        double[][] arr2 = {{3, 15, 18}};
        Matrix matrix2 = new Matrix(arr2);

        double[][] arr = {{10, 20, 30}};
        Matrix expected =  new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(evaluator, matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddNormal_5() {
        double[][] arr1 = {{-2.5, 3.25, 0}, {7.0, -1.125, 3.6}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{3.2, -3.25, 4.25}, {-5.5, 2.25, -4.8}};
        Matrix matrix2 = new Matrix(arr2);

        double[][] arr = {{0.7, 0.0, 4.25}, {1.5, 1.125, -1.2}};
        Matrix expected =  new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(evaluator, matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddBorder_1() {
        double[][] arr1 = {{1, 2}, {3, 4}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{-1, -2}, {-3, -4}};
        Matrix matrix2 = new Matrix(arr2);

        double[][] arr = {{0, 0}, {0, 0}};
        Matrix expected =  new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(evaluator, matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddBorder_2() {
        double[][] arr1 = {{7}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{5}};
        Matrix matrix2 = new Matrix(arr2);

        double[][] arr = {{12}};
        Matrix expected = new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(evaluator, matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testAddImproperNLines() {
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{5, 6}, {2, 3}};
        Matrix matrix2 = new Matrix(arr2);

        expectedException.expect(AddSubtractImpossibleException.class);
        matrixCalc.makeOperation(evaluator, matrix1, matrix2);
    }

    @Test
    public void testAddImproperNColumns() {
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{5}, {2}, {3}};
        Matrix matrix2 = new Matrix(arr2);

        expectedException.expect(AddSubtractImpossibleException.class);
        matrixCalc.makeOperation(evaluator, matrix1, matrix2);
    }

    @Test
    public void testAddDifferentNColumns() {
        double[][] arr1 = {{-2, 3, 0}, {7, 3}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{3, -3, 4}, {-5, 2, -4}};
        Matrix matrix2 = new Matrix(arr2);

        expectedException.expect(MatrixHasDifferentNColumnsException.class);
        matrixCalc.makeOperation(evaluator, matrix1, matrix2);
    }

    @Test
    public void testAddNullMatrix_1() {
        Matrix matrix1 = null;

        double[][] arr2 = {{5, 2}, {2, 3}, {3, -2}};
        Matrix matrix2 = new Matrix(arr2);

        expectedException.expect(MatrixNullPointerException.class);
        matrixCalc.makeOperation(evaluator, matrix1, matrix2);
    }

    @Test
    public void testAddNullMatrix_2() {
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        Matrix matrix1 = new Matrix(arr1);

        Matrix matrix2 = null;

        expectedException.expect(MatrixNullPointerException.class);
        matrixCalc.makeOperation(evaluator, matrix1, matrix2);
    }
}