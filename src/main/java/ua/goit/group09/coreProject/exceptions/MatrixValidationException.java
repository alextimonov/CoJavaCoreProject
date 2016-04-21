package ua.goit.group09.coreProject.exceptions;

/**
 * Class for exception which mean that given matrix is not valid
 */
public class MatrixValidationException extends IllegalArgumentException {

    public MatrixValidationException(String message) {
        super(message);
    }
}
