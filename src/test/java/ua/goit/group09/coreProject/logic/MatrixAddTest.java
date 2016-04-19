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
        double[][] arr1 = {{1, 2}, {3, 4}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{0, 0}, {0, 0}};
        Matrix matrix2 = new Matrix(arr2);

        Matrix expected = matrix1;
        Matrix actual = matrixCalc.makeOperation(sum, matrix1, matrix2, 0);
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

        Matrix actual = matrixCalc.makeOperation(sum, matrix1, matrix2, 0);
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

        Matrix actual = matrixCalc.makeOperation(sum, matrix1, matrix2, 0);
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

        Matrix actual = matrixCalc.makeOperation(sum, matrix1, matrix2, 0);
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

        Matrix actual = matrixCalc.makeOperation(sum, matrix1, matrix2, 0);
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

        Matrix actual = matrixCalc.makeOperation(sum, matrix1, matrix2, 0);
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

        Matrix actual = matrixCalc.makeOperation(sum, matrix1, matrix2, 0);
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

        expectedException.expect(CantBeAddedSubtractedException.class);
        matrixCalc.makeOperation(sum, matrix1, matrix2, 0);
    }

    @Test
    public void testAddImproperNColumns() {
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{5}, {2}, {3}};
        Matrix matrix2 = new Matrix(arr2);

        expectedException.expect(CantBeAddedSubtractedException.class);
        matrixCalc.makeOperation(sum, matrix1, matrix2, 0);
    }

    /*@Test
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
    }*/
}