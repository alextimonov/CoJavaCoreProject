package ua.goit.group09.coreProject.exceptions;

/**
 * Created by Alex on 19.04.2016.
 */
public class MatricesCantBeOperatedException extends IllegalArgumentException {
    private String message;

    public MatricesCantBeOperatedException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
