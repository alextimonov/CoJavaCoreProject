package ua.goit.group09.coreProject.logic;

import ua.goit.group09.coreProject.data.Matrix;

import java.util.LinkedList;
import java.util.List;

/**
 * Class with realisation of evaluation the multiplication of two matrices using ForkJoin
 */
public class EvaluatorMultiply extends Evaluator  {

    /**
     * finds the multiplication of two matrices
     * @param matrix1             multiplied matrix #1
     * @param matrix2             multiplied matrix #2
     * @return result of multiplication
     */
    @Override
    public Matrix evaluate(Matrix matrix1, Matrix matrix2) {
        double[][] resultArray = new double[matrix1.getLines()][matrix2.getColumns()];
        List<ForkJoinMultiplier> listTasks = new LinkedList<>();
        for (int i = 0; i < matrix1.getLines(); i++) {
            for (int j = 0; j < matrix2.getColumns(); j++) {
                ForkJoinMultiplier task = new ForkJoinMultiplier(matrix1, matrix2, i, j);
                listTasks.add(task);
                task.fork();
            }
        }
        int k = 0;
        for (int i = 0; i < matrix1.getLines(); i++) {
            for (int j = 0; j < matrix2.getColumns(); j++) {
                resultArray[i][j] = listTasks.get(k++).join();
            }
        }
        return new Matrix(resultArray);
    }
}
