package edu.lemon.generics;

public class GenericClass<T> {
    T value;

    public GenericClass(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    private void method1(T[] array){}

}
