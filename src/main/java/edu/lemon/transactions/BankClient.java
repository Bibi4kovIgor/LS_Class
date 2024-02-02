package edu.lemon.transactions;

import java.util.Arrays;
import java.util.UUID;

public class BankClient extends Person {
    private final BankCard[] bankCards;
    public BankClient(String cardHolderName, int cardHolderAge, String cardHolderEmail,  BankCard[] bankCards) {
        super(UUID.randomUUID(), cardHolderName, cardHolderAge, cardHolderEmail);
        this.bankCards = bankCards;

    }

    public BankCard[] getBankAccounts() {
        return bankCards;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof BankClient that)) return false;
        if (!super.equals(object)) return false;
        return Arrays.equals(bankCards, that.bankCards);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(bankCards);
        return result;
    }

    @Override
    public String toString() {
        return "BankClient{" +
                "bankCards=" + Arrays.toString(bankCards) +
                '}';
    }
}
