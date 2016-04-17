package ua.goit.group09.coreProject;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.goit.group09.coreProject.data.MatrixData;
import ua.goit.group09.coreProject.logic.MatrixCalc;
import ua.goit.group09.coreProject.logic.MatrixCalcDefault;
import ua.goit.group09.coreProject.logic.MatrixCalcProperMatricesValidator;
import ua.goit.group09.coreProject.logic.MatrixCalcValidator;

import static org.junit.Assert.*;

/**
 * Testing class for method multiply of class MatrixCalcDefault
 */
public class MatrixAddTest {
    MatrixCalc matrixCalc =
            new MatrixCalcValidator
                 (new MatrixCalcProperMatricesValidator
                       (new MatrixCalcDefault()));


    @Test
    public void testAddNormal_1() {
        MatrixData matrix1 = new MatrixData(2, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(2, 2);
        double[][] arr2 = {{0, 0}, {0, 0}};
        matrix2.setArray(arr2);

        MatrixData expected = matrix1;
        MatrixData actual = matrixCalc.add(matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddNormal_2() {
        MatrixData matrix1 = new MatrixData(2, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(2, 2);
        double[][] arr2 = {{5, 6}, {7, 8}};
        matrix2.setArray(arr2);

        MatrixData expected =  new MatrixData(2, 2);
        double[][] arr = {{6, 8}, {10, 12}};
        expected.setArray(arr);

        MatrixData actual = matrixCalc.add(matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddNormal_3() {
        MatrixData matrix1 = new MatrixData(3, 2);
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(3, 2);
        double[][] arr2 = {{7, 6}, {5, 4}, {3, 2}};
        matrix2.setArray(arr2);

        MatrixData expected =  new MatrixData(3, 2);
        double[][] arr = {{8, 8}, {8, 8}, {8, 8}};
        expected.setArray(arr);

        MatrixData actual = matrixCalc.add(matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddNormal_4() {
        MatrixData matrix1 = new MatrixData(1, 3);
        double[][] arr1 = {{7, 5, 12}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(1, 3);
        double[][] arr2 = {{3, 15, 18}};
        matrix2.setArray(arr2);

        MatrixData expected =  new MatrixData(1, 3);
        double[][] arr = {{10, 20, 30}};
        expected.setArray(arr);

        MatrixData actual = matrixCalc.add(matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddBorder_1() {
        MatrixData matrix1 = new MatrixData(2, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(2, 2);
        double[][] arr2 = {{-1, -2}, {-3, -4}};
        matrix2.setArray(arr2);

        MatrixData expected =  new MatrixData(2, 2);
        double[][] arr = {{0, 0}, {0, 0}};
        expected.setArray(arr);

        MatrixData actual = matrixCalc.add(matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddBorder_2() {
        MatrixData matrix1 = new MatrixData(1, 1);
        double[][] arr1 = {{7}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(1, 1);
        double[][] arr2 = {{5}};
        matrix2.setArray(arr2);

        MatrixData expected =  new MatrixData(1, 1);
        double[][] arr = {{12}};
        expected.setArray(arr);

        MatrixData actual = matrixCalc.add(matrix1, matrix2);
        assertEquals(expected, actual);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testMultiplyImproperNLines() {
        MatrixData matrix1 = new MatrixData(3, 2);
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(2, 2);
        double[][] arr2 = {{5, 6}, {2, 3}};
        matrix2.setArray(arr2);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("different number of lines or columns");
        matrixCalc.add(matrix1, matrix2);
    }

    @Test
    public void testAddImproperNColumns() {
        MatrixData matrix1 = new MatrixData(3, 2);
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(3, 1);
        double[][] arr2 = {{5}, {2}, {3}};
        matrix2.setArray(arr2);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("different number of lines or columns");
        matrixCalc.add(matrix1, matrix2);
    }

    @Test
    public void testAddLessThanOneLine() {
        MatrixData matrix1 = new MatrixData(-1, 2);

        MatrixData matrix2 = new MatrixData(2, 2);
        double[][] arr2 = {{5, 6}, {3, 7}};
        matrix2.setArray(arr2);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("less than one line or column");
        matrixCalc.add(matrix1, matrix2);
    }

    @Test
    public void testAddLessThanOneColumn() {
        MatrixData matrix1 = new MatrixData(2, 2);
        double[][] arr1 = {{5, 6}, {3, 7}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(2, 0);

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("less than one line or column");
        matrixCalc.add(matrix1, matrix2);
    }

    /*@Test
    public void testSubtractNormal_1() {
        MatrixData matrix1 = new MatrixData(2, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(2, 2);
        double[][] arr2 = {{0, 0}, {0, 0}};
        matrix2.setArray(arr2);

        MatrixData expected = matrix1;
        MatrixData actual = matrix1.subtract(matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractNormal_2() {
        MatrixData matrix1 = new MatrixData(2, 2);
        double[][] arr1 = {{6, 8}, {10, 12}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(2, 2);
        double[][] arr2 = {{5, 6}, {7, 8}};
        matrix2.setArray(arr2);

        MatrixData expected =  new MatrixData(2, 2);
        double[][] arr = {{1, 2}, {3, 4}};
        expected.setArray(arr);

        MatrixData actual = matrix1.subtract(matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractNormal_3() {
        MatrixData matrix1 = new MatrixData(3, 2);
        double[][] arr1 = {{8, 8}, {8, 8}, {8, 8}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(3, 2);
        double[][] arr2 = {{7, 6}, {5, 4}, {3, 2}};
        matrix2.setArray(arr2);

        MatrixData expected =  new MatrixData(3, 2);
        double[][] arr = {{1, 2}, {3, 4}, {5, 6}};
        expected.setArray(arr);

        MatrixData actual = matrix1.subtract(matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractNormal_4() {
        MatrixData matrix1 = new MatrixData(1, 3);
        double[][] arr1 = {{10, 20, 30}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(1, 3);
        double[][] arr2 = {{3, 15, 18}};
        matrix2.setArray(arr2);

        MatrixData expected =  new MatrixData(1, 3);
        double[][] arr = {{7, 5, 12}};
        expected.setArray(arr);

        MatrixData actual = matrix1.subtract(matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractBorder_1() {
        MatrixData matrix1 = new MatrixData(2, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(2, 2);
        double[][] arr2 = {{1, 2}, {3, 4}};
        matrix2.setArray(arr2);

        MatrixData expected = new MatrixData(2, 2);
        double[][] arr = {{0, 0}, {0, 0}};
        expected.setArray(arr);

        MatrixData actual = matrix1.subtract(matrix2);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtractBorder_2() {
        MatrixData matrix1 = new MatrixData(1, 1);
        double[][] arr1 = {{12}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(1, 1);
        double[][] arr2 = {{7}};
        matrix2.setArray(arr2);

        MatrixData expected =  new MatrixData(1, 1);
        double[][] arr = {{5}};
        expected.setArray(arr);

        MatrixData actual = matrix1.subtract(matrix2);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtractAbnormal_1() {
        MatrixData matrix1 = new MatrixData(3, 2);
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 6}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(2, 3);
        double[][] arr2 = {{5, 6, 7}, {1, 2, 3}};
        matrix2.setArray(arr2);

        MatrixData actual = matrix1.subtract(matrix2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtractAbnormal_2() {
        MatrixData matrix1 = new MatrixData(-2, 2);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix1.setArray(arr1);

        MatrixData matrix2 = new MatrixData(2, 2);
        double[][] arr2 = {{5, 6}, {3, 7}};
        matrix2.setArray(arr2);

        MatrixData actual = matrix1.subtract(matrix2);
    }*/
}