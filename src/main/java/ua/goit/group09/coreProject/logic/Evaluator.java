package ua.goit.group09.coreProject.logic;

import ua.goit.group09.coreProject.data.Matrix;

/**
 * Interface with method of evaluation different operations with matrices
 */
interface Evaluator {
    Matrix evaluate(MathOperation mathOperation, Matrix matrix1, Matrix matrix2);
}
