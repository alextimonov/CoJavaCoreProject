package ua.goit.group09.coreProject.exceptions;

/**
 * Class for exception which means that multiplication of matrices is impossible due to
 * an unequal number of first matrix's columns and number of second matrix's lines
 */
public class MultiplyImpossibleException extends MatrixOperationImpossibleException {

    public MultiplyImpossibleException(String message) {
        super(message);
    }
}
