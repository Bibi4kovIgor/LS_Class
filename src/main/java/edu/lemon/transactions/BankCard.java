package edu.lemon.transactions;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public final class BankCard {
    private final UUID cardId;
    private BigDecimal totalAmount;
    private final String cardName;

    public BankCard(UUID cardId, BigDecimal totalAmount, String cardName) {
        this.cardId = cardId;
        this.totalAmount = totalAmount;
        this.cardName = cardName;
    }

    public UUID cardId() {
        return cardId;
    }

    public BigDecimal totalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String cardName() {
        return cardName;
    }



    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (BankCard) obj;
        return Objects.equals(this.cardId, that.cardId) &&
                Objects.equals(this.totalAmount, that.totalAmount) &&
                Objects.equals(this.cardName, that.cardName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardId, totalAmount, cardName);
    }

    @Override
    public String toString() {
        return "BankCard[" +
                "cardId=" + cardId + ", " +
                "totalAmount=" + totalAmount + ", " +
                "cardName=" + cardName + ']';
    }
}
