package edu.lemon.transactions;

import java.math.BigDecimal;
import java.util.Optional;

public class PreparePayment implements Processable, Paymentable {
    private final BankClient bankClient;
    private final BankCard bankCard;
    private PreparePayment(BankClient bankClient, BankCard bankCard) {
        this.bankClient = bankClient;
        this.bankCard = bankCard;
    }

    public static PreparePayment getPaymentCard(BankClient bankClient, String bankAccountName){
        BankCard bankCard = getClientsAccountByName(bankClient, bankAccountName)
                // This code returns error if bank account doesn't exist
                .orElseThrow(() -> new UnsupportedOperationException("Payment card was not found"));
        return new PreparePayment(bankClient, bankCard);
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
