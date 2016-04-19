package ua.goit.group09.coreProject.exceptions;

/**
 * Created by Alex on 19.04.2016.
 */
public class CantBeMultipliedException extends MatricesCantBeOperatedException {
    public CantBeMultipliedException(String message) {
        super(message);
    }
}
