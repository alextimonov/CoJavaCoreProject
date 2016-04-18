package ua.goit.group09.coreProject.logic;

import ua.goit.group09.coreProject.data.Matrix;

/**
 * Interface with matrix arithmetic logic
 */
public interface MatrixCalc {
    Matrix sum(Matrix addend1, Matrix addend2);
    Matrix subtract(Matrix minuend, Matrix subtrahend);
    Matrix multiply(Matrix multiplier1, Matrix multiplier2);
    Matrix multiply(double number, Matrix multiplier);
}