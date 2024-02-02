package edu.lemon.generics.launcher;

import edu.lemon.generics.Account;
import edu.lemon.generics.Bond;
import edu.lemon.generics.GenericClass;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

public class Launcher {
    public static void main(String[] args) {
        String[] strings = {"string 1", "string 2", "string 3"};

        Account<String[], BigDecimal> account = new Account<>(strings, "some@email.com", new BigDecimal("1000"));

        System.out.println(account);

        Account<UUID, BigDecimal> bankAccount =
                new Account<>(UUID.randomUUID(), "some1@email.com", new BigDecimal("13245453456"));
        System.out.println(bankAccount);

        Account<Long, String> buisinessAccount =
                new Account<>(1L, "some2@email.com", "10 kg of gold");
        System.out.println(buisinessAccount);

        Account<String, Bond> forexAccount =
                new Account<>("uid1", "some3@email.com",
                        new Bond("City Bank", 125L, new BigDecimal("345.11"), LocalDateTime.now()));
        System.out.println(forexAccount);

        GenericClass<Double> doubleGenericClass = new GenericClass<>(1324.3124);
        GenericClass<Object> objectGenericClass = new GenericClass<>(new Object());
        GenericClass<Number> numberGenericClass = new GenericClass<>(444785);

        System.out.println(Arrays.toString(getByteCode(numberGenericClass)));
        System.out.println(Arrays.toString(getByteCode(doubleGenericClass)));
        System.out.println(Arrays.toString(getByteCode(objectGenericClass)));


    }
    private static byte[] getByteCode(GenericClass<? super Double> number) {
        return number.getValue().toString().getBytes();
    }
    private static Account<String, Bond> bitCoinAccountToForexAccount(Account<UUID, BigDecimal> accounts) {
        return new Account<>(accounts.id().toString(), accounts.email(),
                new Bond(accounts.email(), 1L, accounts.sum(), LocalDateTime.now()));
    }
}
