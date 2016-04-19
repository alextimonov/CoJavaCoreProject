package ua.goit.group09.coreProject.exceptions;

/**
 * Created by Alex on 19.04.2016.
 */
public class LessThanOneLineColumnException extends MatrixValidationException {

    public LessThanOneLineColumnException(String message) {
        super(message);
    }
}
