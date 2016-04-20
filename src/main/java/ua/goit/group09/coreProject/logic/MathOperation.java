package ua.goit.group09.coreProject.logic;

/**
 * Enum with types of math operations for matrices and
 * double number - multiplier for multiplication of double number and matrix
 */
public enum MathOperation {
    SUM_MATRICES,
    SUBTRACT_MATRICES,
    MULTIPLY_MATRICES,
    MULTIPLY_NUMBER_AND_MATRIX;

    // multiplier for multiplication of double number and matrix
    private double doubleMultiplier;

    public double getDoubleMultiplier() {
        return doubleMultiplier;
    }

    public void setDoubleMultiplier(double doubleMultiplier) {
        this.doubleMultiplier = doubleMultiplier;
    }
}