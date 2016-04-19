package ua.goit.group09.coreProject.exceptions;

/**
 * Class for exceptions which mean that math operation with matrices is impossible due to
 * improper number of lines or columns
 */
public class MatrixOperationImpossibleException extends IllegalArgumentException {

    public MatrixOperationImpossibleException(String s) {
        super(s);
    }
}
