package ua.goit.group09.coreProject.logic;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.goit.group09.coreProject.data.Matrix;
import ua.goit.group09.coreProject.exceptions.*;

import static org.junit.Assert.*;

/**
 * Testing class for mrethod multiply of class MatrixCalcDefault
 */
public class MatrixMultiplyTest {
    private static MatrixCalc matrixCalc =
            (new MatricesValidator
                    (new MatricesCanBeOperatedValidator
                            (new MatrixCalcDefault())));
    MathOperation multiply = MathOperation.MULTIPLY_MATRICES;

    @Test
    public void testMultiplyNormal_1() {
        double[][] arr1 = {{2, 3}, {4, 2}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{1, 0}, {0, 1}};
        Matrix matrix2 = new Matrix(arr2);

        Matrix expected = matrix1;
        Matrix actual = matrixCalc.makeOperation(multiply, matrix1, matrix2, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyNormal_2() {
        double[][] arr1 = {{1, 2}, {3, 4}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{4, 2}, {1, 2}};
        Matrix matrix2 = new Matrix(arr2);

        double[][] arr = {{6, 6}, {16, 14}};
        Matrix expected = new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(multiply, matrix1, matrix2, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyNormal_3() {
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{4, 3, 2, 1}, {1, 2, 3, 4}};
        Matrix matrix2 = new Matrix(arr2);

        double[][] arr = {{6, 7, 8, 9}, {16, 17, 18, 19}, {26, 27, 28, 29}};
        Matrix expected = new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(multiply, matrix1, matrix2, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyNormal_4() {
        double[][] arr1 = {{1}, {1}, {1}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{1, 1, 1}};
        Matrix matrix2 = new Matrix(arr2);

        double[][] arr = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        Matrix expected = new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(multiply, matrix1, matrix2, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyNormal_5() {
        double[][] arr1 = {{-2.5, 3.25, 0}, {7.0, -1.125, 3.6}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{3.2, -3.25}, {4.25, -5.5}, {2.25, -4.8}};
        Matrix matrix2 = new Matrix(arr2);

        double[][] arr = {{5.8125, -9.75}, {25.71875, -33.8425}};
        Matrix expected = new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(multiply, matrix1, matrix2, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyBorder_1() {
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{0, 0}, {0, 0}};
        Matrix matrix2 = new Matrix(arr2);

        double[][] arr = {{0, 0}, {0, 0}, {0, 0}};
        Matrix expected = new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(multiply, matrix1, matrix2, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyBorder_2() {
        double[][] arr1 = {{7}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{5}};
        Matrix matrix2 = new Matrix(arr2);

        double[][] arr = {{35}};
        Matrix expected = new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(multiply, matrix1, matrix2, 0);
        assertEquals(expected, actual);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testMultiplyImproperNLines_1() {
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{5, 6, 7}};
        Matrix matrix2 = new Matrix(arr2);

        expectedException.expect(CantBeMultipliedException.class);
        matrixCalc.makeOperation(multiply, matrix1, matrix2, 0);
    }

    @Test
    public void testMultiplyImproperNLines_2() {
        double[][] arr1 = {{1, 2}, {3, 4}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{5, 6}, {2, 3}, {1, 2}};
        Matrix matrix2 = new Matrix(arr2);

        expectedException.expect(CantBeMultipliedException.class);
        matrixCalc.makeOperation(multiply, matrix1, matrix2, 0);
    }

    /*@Test
    public void testMultiplyLessThanOneLine() {
        Matrix matrix1 = new Matrix(-2, 2);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{5, 6}, {3, 7}};
        matrix2.setArray(arr2);

        expectedException.expect(LessThanOneLineColumnException.class);
        matrixCalc.makeOperation(multiply, matrix1, matrix2, 0);
    }

    @Test
    public void testMultiplyLessThanOneColumn() {
        Matrix matrix1 = new Matrix(3, 2);
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 0);
        double[][] arr2 = {{5, 6}, {3, 7}};
        matrix2.setArray(arr2);

        expectedException.expect(LessThanOneLineColumnException.class);
        matrixCalc.makeOperation(multiply, matrix1, matrix2, 0);
    }

    @Test
    public void testMultiplyWrongNLines() {
        Matrix matrix1 = new Matrix(3, 2);
        double[][] arr1 = {{3, -1}, {-4, 7}, {1, 2}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(3, 2);
        double[][] arr2 = {{5, 6}, {3, 7}};
        matrix2.setArray(arr2);

        expectedException.expect(WrongNLinesColumnsException.class);
        matrixCalc.makeOperation(multiply, matrix1, matrix2, 0);
    }*/
}