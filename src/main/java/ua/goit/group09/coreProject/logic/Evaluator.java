package ua.goit.group09.coreProject.logic;

import ua.goit.group09.coreProject.data.Matrix;

/**
 * Created by Alex on 20.04.2016.
 */
interface Evaluator {
    Matrix evaluate(MathOperation mathOperation, Matrix matrix1, Matrix matrix2);
}
