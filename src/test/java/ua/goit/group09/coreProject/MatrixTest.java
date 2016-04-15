package ua.goit.group09.coreProject;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * Testing class for Matrix
 */
public class MatrixTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testMultiplyNormal_1() {
        Matrix matrix1 = new Matrix(2, 2);
        double[][] arr1 = {{2, 3}, {4, 2}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{1, 0}, {0, 1}};
        matrix2.setArray(arr2);

        Matrix expected = matrix1;
        Matrix actual = matrix1.multiply(matrix2);
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

        Matrix expected =  new Matrix(2, 2);
        double[][] arr = {{6, 6}, {16, 14}};
        expected.setArray(arr);

        Matrix actual = matrix1.multiply(matrix2);
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

        Matrix expected =  new Matrix(3, 4);
        double[][] arr = {{6, 7, 8, 9}, {16, 17, 18, 19}, {26, 27, 28, 29}};
        expected.setArray(arr);

        Matrix actual = matrix1.multiply(matrix2);
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

        Matrix expected =  new Matrix(3, 3);
        double[][] arr = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        expected.setArray(arr);

        Matrix actual = matrix1.multiply(matrix2);
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

        Matrix expected =  new Matrix(3, 2);
        double[][] arr = {{0, 0}, {0, 0}, {0, 0}};
        expected.setArray(arr);

        Matrix actual = matrix1.multiply(matrix2);
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

        Matrix expected =  new Matrix(1, 1);
        double[][] arr = {{35}};
        expected.setArray(arr);

        Matrix actual = matrix1.multiply(matrix2);
        assertEquals(expected, actual);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testMultiplyImproperNLines() {
        Matrix matrix1 = new Matrix(3, 2);
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(1, 3);
        double[][] arr2 = {{5, 6, 7}};
        matrix2.setArray(arr2);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("improper number of lines");
        matrix1.multiply(matrix2);
    }

    @Ignore
    @Test
    public void testMultiplyLessThanOneLine() {
        Matrix matrix1 = new Matrix(-2, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{5, 6}, {3, 7}};
        matrix2.setArray(arr2);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("less than one");
        matrix1.multiply(matrix2);
    }

    @Test
    public void testAddNormal_1() {
        Matrix matrix1 = new Matrix(2, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{0, 0}, {0, 0}};
        matrix2.setArray(arr2);

        Matrix expected = matrix1;
        Matrix actual = matrix1.add(matrix2);
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

        Matrix actual = matrix1.add(matrix2);
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

        Matrix actual = matrix1.add(matrix2);
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

        Matrix actual = matrix1.add(matrix2);
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

        Matrix actual = matrix1.add(matrix2);
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

        Matrix actual = matrix1.add(matrix2);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAbnormal_1() {
        Matrix matrix1 = new Matrix(3, 2);
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(1, 3);
        double[][] arr2 = {{5, 6, 7}};
        matrix2.setArray(arr2);

        Matrix actual = matrix1.add(matrix2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddAbnormal_2() {
        Matrix matrix1 = new Matrix(-2, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{5, 6}, {3, 7}};
        matrix2.setArray(arr2);

        Matrix actual = matrix1.add(matrix2);
    }

    @Test
    public void testSubtractNormal_1() {
        Matrix matrix1 = new Matrix(2, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{0, 0}, {0, 0}};
        matrix2.setArray(arr2);

        Matrix expected = matrix1;
        Matrix actual = matrix1.subtract(matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractNormal_2() {
        Matrix matrix1 = new Matrix(2, 2);
        double[][] arr1 = {{6, 8}, {10, 12}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{5, 6}, {7, 8}};
        matrix2.setArray(arr2);

        Matrix expected =  new Matrix(2, 2);
        double[][] arr = {{1, 2}, {3, 4}};
        expected.setArray(arr);

        Matrix actual = matrix1.subtract(matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractNormal_3() {
        Matrix matrix1 = new Matrix(3, 2);
        double[][] arr1 = {{8, 8}, {8, 8}, {8, 8}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(3, 2);
        double[][] arr2 = {{7, 6}, {5, 4}, {3, 2}};
        matrix2.setArray(arr2);

        Matrix expected =  new Matrix(3, 2);
        double[][] arr = {{1, 2}, {3, 4}, {5, 6}};
        expected.setArray(arr);

        Matrix actual = matrix1.subtract(matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractNormal_4() {
        Matrix matrix1 = new Matrix(1, 3);
        double[][] arr1 = {{10, 20, 30}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(1, 3);
        double[][] arr2 = {{3, 15, 18}};
        matrix2.setArray(arr2);

        Matrix expected =  new Matrix(1, 3);
        double[][] arr = {{7, 5, 12}};
        expected.setArray(arr);

        Matrix actual = matrix1.subtract(matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractBorder_1() {
        Matrix matrix1 = new Matrix(2, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{1, 2}, {3, 4}};
        matrix2.setArray(arr2);

        Matrix expected = new Matrix(2, 2);
        double[][] arr = {{0, 0}, {0, 0}};
        expected.setArray(arr);

        Matrix actual = matrix1.subtract(matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractBorder_2() {
        Matrix matrix1 = new Matrix(1, 1);
        double[][] arr1 = {{12}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(1, 1);
        double[][] arr2 = {{7}};
        matrix2.setArray(arr2);

        Matrix expected =  new Matrix(1, 1);
        double[][] arr = {{5}};
        expected.setArray(arr);

        Matrix actual = matrix1.subtract(matrix2);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtractAbnormal_1() {
        Matrix matrix1 = new Matrix(3, 2);
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 3);
        double[][] arr2 = {{5, 6, 7}, {1, 2, 3}};
        matrix2.setArray(arr2);

        Matrix actual = matrix1.subtract(matrix2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtractAbnormal_2() {
        Matrix matrix1 = new Matrix(-2, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        Matrix matrix2 = new Matrix(2, 2);
        double[][] arr2 = {{5, 6}, {3, 7}};
        matrix2.setArray(arr2);

        Matrix actual = matrix1.subtract(matrix2);
    }
}