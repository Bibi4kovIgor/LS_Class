package edu.lemon.transactions;

import edu.lemon.transactions.logger.Logger;
import edu.lemon.transactions.logger.LoggerState;

import java.math.BigDecimal;

public class Transaction<T extends PaymentOperation & Processable> implements Transactional {
    private static final String TRANSACTION_START_STATE_MESSAGE = "";
    private static final String TRANSACTION_RUNNING = "Transaction running";
    private static final String TRANSACTION_MESSAGE =
            "Costs %f to earn from %s%n" +
            "Total amount now is %f \n" +
            "Total amount of destination client %s is %f%n";
    private static final Logger LOGGER = Logger.loggerPrintableFactoryWithState();
    public static final String TRANSACTION_ERROR_MESSAGE = "Transaction is not possible";
    private final T from;
    private final T to;
    private final BigDecimal sum;
    private TransactionState transactionState;
    private String transactionStateMessage;

    public Transaction(T from, T to, BigDecimal sum) {
        this.from = from;
        this.to = to;
        this.sum = sum;
        transactionState = TransactionState.RUNNING;
        this.transactionStateMessage = TRANSACTION_START_STATE_MESSAGE;
    }

    @Override
    public void execute() {
        if (from.getTotalAmount().compareTo(sum) >= 0) {
            transactionState = TransactionState.RUNNING;
            LOGGER.log(LoggerState.INFO, transactionState.name());
            transactionStateMessage = TRANSACTION_RUNNING;
            LOGGER.log(LoggerState.INFO, transactionStateMessage);

            outputTransactionString();


            BigDecimal totalSumTo = to.getTotalAmount().add(sum);
            BigDecimal totalSumFrom = from.getTotalAmount().subtract(sum);

            to.setTotalAmount(totalSumTo);
            from.setTotalAmount(totalSumFrom);

            outputTransactionString();

        } else {
            transactionState = TransactionState.FAILED;
            LOGGER.log(LoggerState.ERROR, transactionState.name());
            transactionStateMessage = TRANSACTION_ERROR_MESSAGE;
            LOGGER.log(LoggerState.ERROR, transactionStateMessage);
        }

    }

    private void outputTransactionString() {
        transactionStateMessage = String.format(TRANSACTION_MESSAGE,
                sum, from.getProcessingInfo(),
                from.getTotalAmount(),
                to.getProcessingInfo(), to.getTotalAmount());
        LOGGER.log(LoggerState.INFO, transactionStateMessage);
    }
}
