package ua.goit.group09.coreProject.exceptions;

/**
 * Class for exception which mean that given matrix object points to null and can't be used
 */
public class MatrixNullPointerException extends MatrixValidationException {
    public MatrixNullPointerException(String message) {
        super(message);
    }
}
