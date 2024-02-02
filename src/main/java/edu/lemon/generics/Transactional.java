package edu.lemon.generics;

public class Transactional<T extends GenericClass<T>>{
    public void getAccountInfo (GenericClass<T> generic) {
        System.out.println(generic);
    }

}
