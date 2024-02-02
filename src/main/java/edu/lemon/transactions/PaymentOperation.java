package edu.lemon.transactions;

import java.math.BigDecimal;
import java.util.Optional;

public class PaymentOperation implements Processable, Paymentable {
    private final BankClient bankClient;
    private final BankCard bankCard;
    private PaymentOperation(BankClient bankClient, BankCard bankCard) {
        this.bankClient = bankClient;
        this.bankCard = bankCard;
    }

    public static PaymentOperation createClientTransactionByAccountName(BankClient bankClient, String bankAccountName){
        BankCard bankCard = getClientsAccountByName(bankClient, bankAccountName)
                // This code returns error if bank account doesn't exist
                .orElseThrow(UnsupportedOperationException::new);
        return new PaymentOperation(bankClient, bankCard);
    }

    private static Optional<BankCard> getClientsAccountByName(BankClient bankClient, String bankAccountName) {
        BankCard[] bankCards = bankClient.getBankAccounts();
        for (BankCard bankCard : bankCards) {
            if (bankCard.cardName().equals(bankAccountName)) {
                return Optional.of(bankCard);
            }
        }

        return Optional.empty();
    }

    @Override
    public String getProcessingInfo() {
        return String.format("Bank client info %s within payment method %s",
                bankClient.toString(), bankCard.toString());
    }

    @Override
    public String getCardName() {
        return bankCard.cardName();
    }

    @Override
    public void setTotalAmount(BigDecimal totalAmount) {
        bankCard.setTotalAmount(totalAmount);
    }

    @Override
    public BigDecimal getTotalAmount() {
        return bankCard.totalAmount();
    }
}
