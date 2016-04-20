package ua.goit.group09.coreProject.logic;

/**
 * Factory with method to choose type of Evaluator
 */
public class EvaluatorFactory {
    /**
     * returns object of class that matches to math operation
     * @param mathOperation     type of math operation
     * @return                  object of Evaluator
     */
    public Evaluator getEvaluator(MathOperation mathOperation) {
        Evaluator evaluator = null;
        switch (mathOperation) {
            case SUM_MATRICES: {
                evaluator = new EvaluatorSum();
            }
            break;
            case SUBTRACT_MATRICES: {
                evaluator = new EvaluatorSubtract();
            }
            break;
            case MULTIPLY_MATRICES: {
                evaluator = new EvaluatorMultiply();
            }
            break;
            case MULTIPLY_NUMBER_AND_MATRIX: {
                evaluator = new EvaluatorMultiplyOnNumber();
            }
            break;
        }
        return evaluator;
    }
}
