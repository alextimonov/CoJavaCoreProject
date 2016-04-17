package ua.goit.group09.coreProject;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Testing class for mrethod multiply of class MatrixCalcDefault
 */
public class MatrixMultiplyTest {
    MatrixCalc matrixCalc =
            new MatrixCalcWithImproperMatrices
                    (new MatrixCalcWithInvalidMatrices
                            (new MatrixCalcDefault()));

    @Test
    public void testMultiplyNormal_1() {
        MatrixData matrix1 = new MatrixData(2, 2);
        double[][] arr1 = {{2, 3}, {4, 2}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(2, 2);
        double[][] arr2 = {{1, 0}, {0, 1}};
        matrix2.setArray(arr2);

        MatrixData expected = matrix1;
        MatrixData actual = matrixCalc.multiply(matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyNormal_2() {
        MatrixData matrix1 = new MatrixData(2, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(2, 2);
        double[][] arr2 = {{4, 2}, {1, 2}};
        matrix2.setArray(arr2);

        MatrixData expected = new MatrixData(2, 2);
        double[][] arr = {{6, 6}, {16, 14}};
        expected.setArray(arr);

        MatrixData actual = matrixCalc.multiply(matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyNormal_3() {
        MatrixData matrix1 = new MatrixData(3, 2);
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(2, 4);
        double[][] arr2 = {{4, 3, 2, 1}, {1, 2, 3, 4}};
        matrix2.setArray(arr2);

        MatrixData expected = new MatrixData(3, 4);
        double[][] arr = {{6, 7, 8, 9}, {16, 17, 18, 19}, {26, 27, 28, 29}};
        expected.setArray(arr);

        MatrixData actual = matrixCalc.multiply(matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyNormal_4() {
        MatrixData matrix1 = new MatrixData(3, 1);
        double[][] arr1 = {{1}, {1}, {1}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(1, 3);
        double[][] arr2 = {{1, 1, 1}};
        matrix2.setArray(arr2);

        MatrixData expected = new MatrixData(3, 3);
        double[][] arr = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        expected.setArray(arr);

        MatrixData actual = matrixCalc.multiply(matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyBorder_1() {
        MatrixData matrix1 = new MatrixData(3, 2);
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(2, 2);
        double[][] arr2 = {{0, 0}, {0, 0}};
        matrix2.setArray(arr2);

        MatrixData expected = new MatrixData(3, 2);
        double[][] arr = {{0, 0}, {0, 0}, {0, 0}};
        expected.setArray(arr);

        MatrixData actual = matrixCalc.multiply(matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyBorder_2() {
        MatrixData matrix1 = new MatrixData(1, 1);
        double[][] arr1 = {{7}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(1, 1);
        double[][] arr2 = {{5}};
        matrix2.setArray(arr2);

        MatrixData expected = new MatrixData(1, 1);
        double[][] arr = {{35}};
        expected.setArray(arr);

        MatrixData actual = matrixCalc.multiply(matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testMultiplyImproperNLines_1() {
        MatrixData matrix1 = new MatrixData(3, 2);
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(1, 3);
        double[][] arr2 = {{5, 6, 7}};
        matrix2.setArray(arr2);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("improper number of lines");
        matrixCalc.multiply(matrix1, matrix2);
    }

    @Test
    public void testMultiplyImproperNLines_2() {
        MatrixData matrix1 = new MatrixData(2, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(3, 2);
        double[][] arr2 = {{5, 6}, {2, 3}, {1, 2}};
        matrix2.setArray(arr2);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("improper number of lines");
        matrixCalc.multiply(matrix1, matrix2);
    }

    @Test
    public void testMultiplyLessThanOneLine() {
        MatrixData matrix1 = new MatrixData(-2, 2);

        MatrixData matrix2 = new MatrixData(2, 2);
        double[][] arr2 = {{5, 6}, {3, 7}};
        matrix2.setArray(arr2);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("less than one");
        matrixCalc.multiply(matrix1, matrix2);
    }

    @Test
    public void testMultiplyLessThanOneColumn() {
        MatrixData matrix1 = new MatrixData(3, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(2, 0);
        double[][] arr2 = {{5, 6}, {3, 7}};
        matrix2.setArray(arr2);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("less than one");
        matrixCalc.multiply(matrix1, matrix2);
    }
}