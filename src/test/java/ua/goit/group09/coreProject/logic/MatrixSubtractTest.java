package ua.goit.group09.coreProject.logic;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.goit.group09.coreProject.data.Matrix;
import ua.goit.group09.coreProject.exceptions.*;

import static org.junit.Assert.*;

/**
 * Testing class for method subtract of class MatrixCalcDefault
 */
public class MatrixSubtractTest {
    private static MatrixCalc matrixCalc =
            (new MatricesValidator
                    (new MatricesCanBeOperatedValidator
                            (new MatrixCalcDefault())));
    MathOperation subtract = MathOperation.SUBTRACT_MATRICES;

    @Test
    public void testSubtractNormal_1() {
        double[][] arr1 = {{1, 2}, {3, 4}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{0, 0}, {0, 0}};
        Matrix matrix2 = new Matrix(arr2);

        Matrix expected = matrix1;
        Matrix actual = matrixCalc.makeOperation(subtract, matrix1, matrix2, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractNormal_2() {
        double[][] arr1 = {{6, 8}, {10, 12}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{5, 6}, {7, 8}};
        Matrix matrix2 = new Matrix(arr2);

        double[][] arr = {{1, 2}, {3, 4}};
        Matrix expected = new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(subtract, matrix1, matrix2, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractNormal_3() {
        double[][] arr1 = {{8, 8}, {8, 8}, {8, 8}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{7, 6}, {5, 4}, {3, 2}};
        Matrix matrix2 = new Matrix(arr2);

        double[][] arr = {{1, 2}, {3, 4}, {5, 6}};
        Matrix expected = new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(subtract, matrix1, matrix2, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractNormal_4() {
        double[][] arr1 = {{10, 20, 30}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{3, 15, 18}};
        Matrix matrix2 = new Matrix(arr2);

        double[][] arr = {{7, 5, 12}};
        Matrix expected = new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(subtract, matrix1, matrix2, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractNormal_5() {
        double[][] arr1 = {{-2.5, 3.25, 0}, {7.0, -1.125, 3.6}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{3.2, -3.25, 4.25}, {-5.5, 2.25, -4.8}};
        Matrix matrix2 = new Matrix(arr2);

        double[][] arr = {{-5.7, 6.5, -4.25}, {12.5, -3.375, 8.4}};
        Matrix expected = new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(subtract, matrix1, matrix2, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractBorder_1() {
        double[][] arr1 = {{1, 2}, {3, 4}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{1, 2}, {3, 4}};
        Matrix matrix2 = new Matrix(arr2);

        double[][] arr = {{0, 0}, {0, 0}};
        Matrix expected = new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(subtract, matrix1, matrix2, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractBorder_2() {
        double[][] arr1 = {{12}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{7}};
        Matrix matrix2 = new Matrix(arr2);

        double[][] arr = {{5}};
        Matrix expected = new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(subtract, matrix1, matrix2, 0);
        assertEquals(expected, actual);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testSubtractImproperNLines() {
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{5, 6}, {2, 3}};
        Matrix matrix2 = new Matrix(arr2);

        expectedException.expect(CantBeAddedSubtractedException.class);
        matrixCalc.makeOperation(subtract, matrix1, matrix2, 0);
    }

    @Test
    public void testSubtractImproperNColumns() {
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        Matrix matrix1 = new Matrix(arr1);

        double[][] arr2 = {{5}, {2}, {3}};
        Matrix matrix2 = new Matrix(arr2);

        expectedException.expect(CantBeAddedSubtractedException.class);
        matrixCalc.makeOperation(subtract, matrix1, matrix2, 0);
    }

    /*@Test
    public void testSubtractLessThanOneLine() {
        Matrix matrix1 = new Matrix(-1, 2);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{5, 6}, {3, 7}};
        matrix2.setArray(arr2);

        expectedException.expect(LessThanOneLineColumnException.class);
        matrixCalc.makeOperation(subtract, matrix1, matrix2, 0);
    }

    @Test
    public void testSubtractLessThanOneColumn() {
        Matrix matrix1 = new Matrix(2, 2);
        double[][] arr1 = {{5, 6}, {3, 7}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 0);

        expectedException.expect(LessThanOneLineColumnException.class);
        matrixCalc.makeOperation(subtract, matrix1, matrix2, 0);
    }

    @Test
    public void testSubtractWrongNColumns() {
        Matrix matrix1 = new Matrix(2, 2);
        double[][] arr1 = {{3, -1, 3}, {-4, 7, -2}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{5, 6}, {3, 7}};
        matrix2.setArray(arr2);

        expectedException.expect(WrongNLinesColumnsException.class);
        matrixCalc.makeOperation(subtract, matrix1, matrix2, 0);
    }*/
}