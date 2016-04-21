package ua.goit.group09.coreProject.exceptions;

/**
 * Created by Alex on 22.04.2016.
 */
public class MatrixHasDifferentNColumnsException extends MatrixValidationException {
    public MatrixHasDifferentNColumnsException(String message) {
        super(message);
    }
}
