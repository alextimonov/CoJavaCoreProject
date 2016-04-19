package ua.goit.group09.coreProject.exceptions;

/**
 * Class for exception which means that addition or subtraction of matrices is impossible due to
 * an unequal number of lines or columns
 */
public class AddSubtractImpossibleException extends MatrixOperationImpossibleException {

    public AddSubtractImpossibleException(String message) {
        super(message);
    }
}
