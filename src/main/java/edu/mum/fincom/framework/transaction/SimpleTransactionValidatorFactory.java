package edu.mum.fincom.framework.transaction;

/**
 * @author Issa Fikadu
 */
public class SimpleTransactionValidatorFactory {
    static public TransactionValidator getDepositTransactionValidator(){
        return new DepositTransactionValidator(500);
    }

    static public TransactionValidator getWithdrawTransactionValidator(){
        return new WithdrawTransactionValidator();
    }

}
