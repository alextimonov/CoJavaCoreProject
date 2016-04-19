package ua.goit.group09.coreProject.logic;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.goit.group09.coreProject.data.Matrix;
import ua.goit.group09.coreProject.exceptions.*;

import static org.junit.Assert.*;

/**
 * Created by Alex on 19.04.2016.
 */
public class MatrixNumberMultiplyTest {
    private static MatrixCalc matrixCalc =
            (new MatricesValidator
                    (new MatricesCanBeOperatedValidator
                            (new MatrixCalcDefault())));
    MathOperation multiplyNumber = MathOperation.MULTIPLY_NUMBER_AND_MATRIX;

    @Test
    public void testMultiplyNormal_1() {
        double[][] arr1 = {{2, 3}, {4, 2}};
        Matrix matrix = new Matrix(arr1);

        double number = 1.0;

        Matrix expected = matrix;
        Matrix actual = matrixCalc.makeOperation(multiplyNumber, matrix, null, number);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyNormal_2() {
        double[][] arr1 = {{1, 2}, {3, 4}};
        Matrix matrix = new Matrix(arr1);

        double number = 4.0;

        double[][] arr = {{4, 8}, {12, 16}};
        Matrix expected =  new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(multiplyNumber, matrix, null, number);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyNormal_3() {
        double[][] arr1 = {{1.75, 2.25}, {3.5, 4.0}, {5.6, 6.4}};
        Matrix matrix = new Matrix(arr1);

        double number = 5.25;

        double[][] arr = {{9.1875, 11.8125}, {18.375, 21.0}, {29.4, 33.6}};
        Matrix expected =  new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(multiplyNumber, matrix, null, number);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyNormal_4() {
        double[][] arr1 = {{1}, {1}, {1}};
        Matrix matrix = new Matrix(arr1);

        double number = 7.0;

        double[][] arr = {{7.0}, {7.0}, {7.0}};
        Matrix expected =  new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(multiplyNumber, matrix, null, number);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyBorder_1() {
        double[][] arr1 = {{1, 2}, {3, 4}, {5, 0}};
        Matrix matrix = new Matrix(arr1);

        double number = 0.0;

        double[][] arr = {{0, 0}, {0, 0}, {0, 0}};
        Matrix expected =  new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(multiplyNumber, matrix, null, number);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiplyBorder_2() {
        double[][] arr1 = {{0.0}};
        Matrix matrix = new Matrix(arr1);

        double number = 5.0;

        double[][] arr = {{0.0}};
        Matrix expected =  new Matrix(arr);

        Matrix actual = matrixCalc.makeOperation(multiplyNumber, matrix, null, number);
        assertEquals(expected, actual);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    /*@Test
    public void testMultiplyLessThanOneLine() {
        Matrix matrix = new Matrix(-2, 2);

        double number = -5.0;

        expectedException.expect(LessThanOneLineColumnException.class);
        matrixCalc.makeOperation(multiplyNumber, matrix, null, number);
    }

    @Test
    public void testMultiplyLessThanOneColumn() {
        Matrix matrix = new Matrix(3, 0);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix.setArray(arr1);

        double number = -5.0;

        expectedException.expect(LessThanOneLineColumnException.class);
        matrixCalc.makeOperation(multiplyNumber, matrix, null, number);
    }

    @Test
    public void testMultiplyWrongNColumns() {
        Matrix matrix = new Matrix(2, 3);
        double[][] arr1 = {{1, 2}, {3, 4}};
        matrix.setArray(arr1);

        double number = -5.0;

        expectedException.expect(WrongNLinesColumnsException.class);
        matrixCalc.makeOperation(multiplyNumber, matrix, null, number);
    }*/
}