package edu.lemon.transactions;

@FunctionalInterface
public interface Transactional {
    void execute();
}
