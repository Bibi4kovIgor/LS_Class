package edu.lemon.transactions.launcher;

import edu.lemon.transactions.*;

import java.math.BigDecimal;
import java.util.UUID;

public class Launcher {
    public static void main(String[] args) {
        BankCard[] ihorsBankCards = {
                new BankCard(UUID.randomUUID(), new BigDecimal("52000"), "Visa"),
                new BankCard(UUID.randomUUID(), new BigDecimal("78555"), "Master Card")
        };

        BankCard[] johnsBankCards = {
                new BankCard(UUID.randomUUID(), new BigDecimal("152000"), "Maestro"),
                new BankCard(UUID.randomUUID(), new BigDecimal("18555"), "Master Card")
        };
        BankClient ihorBankClient = new BankClient(
                "Ihor",
                32,
                "work.bibi4kov@gmail.com",
                ihorsBankCards
        );

        BankClient johnBankClient = new BankClient(
                "John",
                45,
                "john.doe@gmail.com",
                johnsBankCards
        );

        // Preparing for transaction
        PreparePayment ihorsMaestroCard =
                PreparePayment.getPaymentCard(ihorBankClient, "Visa");
        PreparePayment ihorsMC =
                PreparePayment.getPaymentCard(ihorBankClient, "Master Card");

        PreparePayment johnMaestro =
                PreparePayment.getPaymentCard(johnBankClient, "Maestro");

        // Execute transactions
        Transactional transaction1 =
                new Transaction<PreparePayment>(ihorsMC, ihorsMaestroCard, new BigDecimal("5000"));
        transaction1.execute();

        // It's not required to specify "PreparePayment" type because it  set up automatically
        Transactional transaction2 =
                new Transaction<>(johnMaestro, ihorsMC, new BigDecimal("15000"));
        transaction2.execute();
    }
}
