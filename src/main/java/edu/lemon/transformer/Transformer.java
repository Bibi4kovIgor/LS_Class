package edu.lemon.transformer;

@FunctionalInterface
public interface Transformer<T, R> {
    R apply(T t);
}
