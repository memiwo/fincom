package edu.mum.fincom.framework.transaction;

/**
 * @author Issa Fikadu
 */
public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
