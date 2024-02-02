package edu.lemon.transactions;

import java.math.BigDecimal;

public interface Paymentable {
    String getCardName() ;
    void setTotalAmount(BigDecimal totalAmount);

    BigDecimal getTotalAmount();
}
