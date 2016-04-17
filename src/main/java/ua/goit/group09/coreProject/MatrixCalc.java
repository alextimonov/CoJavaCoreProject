package ua.goit.group09.coreProject;

/**
 * Interface with matrix arithmetic logic
 */
public interface MatrixCalc {
    MatrixData add(MatrixData addend1, MatrixData addend2);
    MatrixData subtract(MatrixData minuend, MatrixData subtrahend);
    MatrixData multiply(MatrixData multiplier1, MatrixData multiplier2);
    MatrixData multiply(double number, MatrixData multiplier);
}