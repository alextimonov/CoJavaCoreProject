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
    MathOperation sum = MathOperation.SUM_MATRICES;

    @Test
    public void testAddNormal_1() {
        Matrix matrix1 = new Matrix(2, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{0, 0}, {0, 0}};
        matrix2.setArray(arr2);

        Matrix expected = matrix1;
        Matrix actual = matrixCalc.makeOperation(sum, matrix1, matrix2, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddNormal_2() {
        Matrix matrix1 = new Matrix(2, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{5, 6}, {7, 8}};
        matrix2.setArray(arr2);

        Matrix expected =  new Matrix(2, 2);
        double[][] arr = {{6, 8}, {10, 12}};
        expected.setArray(arr);

        Matrix actual = matrixCalc.makeOperation(sum, matrix1, matrix2, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddNormal_3() {
        Matrix matrix1 = new Matrix(3, 2);
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(3, 2);
        double[][] arr2 = {{7, 6}, {5, 4}, {3, 2}};
        matrix2.setArray(arr2);

        Matrix expected =  new Matrix(3, 2);
        double[][] arr = {{8, 8}, {8, 8}, {8, 8}};
        expected.setArray(arr);

        Matrix actual = matrixCalc.makeOperation(sum, matrix1, matrix2, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddNormal_4() {
        Matrix matrix1 = new Matrix(1, 3);
        double[][] arr1 = {{7, 5, 12}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(1, 3);
        double[][] arr2 = {{3, 15, 18}};
        matrix2.setArray(arr2);

        Matrix expected =  new Matrix(1, 3);
        double[][] arr = {{10, 20, 30}};
        expected.setArray(arr);

        Matrix actual = matrixCalc.makeOperation(sum, matrix1, matrix2, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddNormal_5() {
        Matrix matrix1 = new Matrix(2, 3);
        double[][] arr1 = {{-2.5, 3.25, 0}, {7.0, -1.125, 3.6}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 3);
        double[][] arr2 = {{3.2, -3.25, 4.25}, {-5.5, 2.25, -4.8}};
        matrix2.setArray(arr2);

        Matrix expected =  new Matrix(2, 3);
        double[][] arr = {{0.7, 0.0, 4.25}, {1.5, 1.125, -1.2}};
        expected.setArray(arr);

        Matrix actual = matrixCalc.makeOperation(sum, matrix1, matrix2, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddBorder_1() {
        Matrix matrix1 = new Matrix(2, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{-1, -2}, {-3, -4}};
        matrix2.setArray(arr2);

        Matrix expected =  new Matrix(2, 2);
        double[][] arr = {{0, 0}, {0, 0}};
        expected.setArray(arr);

        Matrix actual = matrixCalc.makeOperation(sum, matrix1, matrix2, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddBorder_2() {
        Matrix matrix1 = new Matrix(1, 1);
        double[][] arr1 = {{7}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(1, 1);
        double[][] arr2 = {{5}};
        matrix2.setArray(arr2);

        Matrix expected =  new Matrix(1, 1);
        double[][] arr = {{12}};
        expected.setArray(arr);

        Matrix actual = matrixCalc.makeOperation(sum, matrix1, matrix2, 0);
        assertEquals(expected, actual);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testAddImproperNLines() {
        Matrix matrix1 = new Matrix(3, 2);
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{5, 6}, {2, 3}};
        matrix2.setArray(arr2);

        expectedException.expect(CantBeAddedSubtractedException.class);
        matrixCalc.makeOperation(sum, matrix1, matrix2, 0);
    }

    @Test
    public void testAddImproperNColumns() {
        Matrix matrix1 = new Matrix(3, 2);
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(3, 1);
        double[][] arr2 = {{5}, {2}, {3}};
        matrix2.setArray(arr2);

        expectedException.expect(CantBeAddedSubtractedException.class);
        matrixCalc.makeOperation(sum, matrix1, matrix2, 0);
    }

    @Test
    public void testAddLessThanOneLine() {
        Matrix matrix1 = new Matrix(-1, 2);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{5, 6}, {3, 7}};
        matrix2.setArray(arr2);

        expectedException.expect(LessThanOneLineColumnException.class);
        matrixCalc.makeOperation(sum, matrix1, matrix2, 0);
    }

    @Test
    public void testAddLessThanOneColumn() {
        Matrix matrix1 = new Matrix(2, 2);
        double[][] arr1 = {{5, 6}, {3, 7}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 0);

        expectedException.expect(LessThanOneLineColumnException.class);
        matrixCalc.makeOperation(sum, matrix1, matrix2, 0);
    }

    @Test
    public void testAddWrongNLines() {
        Matrix matrix1 = new Matrix(2, 2);
        double[][] arr1 = {{3, -1}, {-4, 7}, {1, 2}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{5, 6}, {3, 7}};
        matrix2.setArray(arr2);

        expectedException.expect(WrongNLinesColumnsException.class);
        matrixCalc.makeOperation(sum, matrix1, matrix2, 0);
    }
}