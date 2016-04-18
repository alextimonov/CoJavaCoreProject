package ua.goit.group09.coreProject;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.goit.group09.coreProject.data.Matrix;
import ua.goit.group09.coreProject.logic.MatrixCalc;
import ua.goit.group09.coreProject.logic.MatrixCalcDefault;
import ua.goit.group09.coreProject.logic.MatricesCanBeOperatedValidator;
import ua.goit.group09.coreProject.logic.MatricesValidator;

import static org.junit.Assert.*;

/**
 * Testing class for mrethod multiply of class MatrixCalcDefault
 */
public class MatrixMultiplyTest {
    MatrixCalc matrixCalc =
            new MatricesCanBeOperatedValidator
                    (new MatricesValidator
                            (new MatrixCalcDefault()));

    @Test
    public void testMultiplyNormal_1() {
        Matrix matrix1 = new Matrix(2, 2);
        double[][] arr1 = {{2, 3}, {4, 2}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{1, 0}, {0, 1}};
        matrix2.setArray(arr2);

        Matrix expected = matrix1;
        Matrix actual = matrixCalc.multiply(matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyNormal_2() {
        Matrix matrix1 = new Matrix(2, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{4, 2}, {1, 2}};
        matrix2.setArray(arr2);

        Matrix expected = new Matrix(2, 2);
        double[][] arr = {{6, 6}, {16, 14}};
        expected.setArray(arr);

        Matrix actual = matrixCalc.multiply(matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyNormal_3() {
        Matrix matrix1 = new Matrix(3, 2);
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 4);
        double[][] arr2 = {{4, 3, 2, 1}, {1, 2, 3, 4}};
        matrix2.setArray(arr2);

        Matrix expected = new Matrix(3, 4);
        double[][] arr = {{6, 7, 8, 9}, {16, 17, 18, 19}, {26, 27, 28, 29}};
        expected.setArray(arr);

        Matrix actual = matrixCalc.multiply(matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyNormal_4() {
        Matrix matrix1 = new Matrix(3, 1);
        double[][] arr1 = {{1}, {1}, {1}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(1, 3);
        double[][] arr2 = {{1, 1, 1}};
        matrix2.setArray(arr2);

        Matrix expected = new Matrix(3, 3);
        double[][] arr = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        expected.setArray(arr);

        Matrix actual = matrixCalc.multiply(matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyBorder_1() {
        Matrix matrix1 = new Matrix(3, 2);
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{0, 0}, {0, 0}};
        matrix2.setArray(arr2);

        Matrix expected = new Matrix(3, 2);
        double[][] arr = {{0, 0}, {0, 0}, {0, 0}};
        expected.setArray(arr);

        Matrix actual = matrixCalc.multiply(matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyBorder_2() {
        Matrix matrix1 = new Matrix(1, 1);
        double[][] arr1 = {{7}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(1, 1);
        double[][] arr2 = {{5}};
        matrix2.setArray(arr2);

        Matrix expected = new Matrix(1, 1);
        double[][] arr = {{35}};
        expected.setArray(arr);

        Matrix actual = matrixCalc.multiply(matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testMultiplyImproperNLines_1() {
        Matrix matrix1 = new Matrix(3, 2);
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(1, 3);
        double[][] arr2 = {{5, 6, 7}};
        matrix2.setArray(arr2);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("improper number of lines");
        matrixCalc.multiply(matrix1, matrix2);
    }

    @Test
    public void testMultiplyImproperNLines_2() {
        Matrix matrix1 = new Matrix(2, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(3, 2);
        double[][] arr2 = {{5, 6}, {2, 3}, {1, 2}};
        matrix2.setArray(arr2);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("improper number of lines");
        matrixCalc.multiply(matrix1, matrix2);
    }

    @Test
    public void testMultiplyLessThanOneLine() {
        Matrix matrix1 = new Matrix(-2, 2);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{5, 6}, {3, 7}};
        matrix2.setArray(arr2);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("less than one");
        matrixCalc.multiply(matrix1, matrix2);
    }

    @Test
    public void testMultiplyLessThanOneColumn() {
        Matrix matrix1 = new Matrix(3, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 0);
        double[][] arr2 = {{5, 6}, {3, 7}};
        matrix2.setArray(arr2);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("less than one");
        matrixCalc.multiply(matrix1, matrix2);
    }
}