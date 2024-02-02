package edu.lemon.collections;

import edu.lemon.collections.arraylist.ArrayList;

public class Launcher {
  public static void main(String[] args) {
	  ArrayList<String> fruits = new ArrayList<>();
    fruits.add("banana");
    fruits.add("pineapple");
    fruits.add("apple");
    fruits.add("banana");
    fruits.add("raspberry");
    fruits.add("raspberry");
    fruits.add("pear");

    System.out.println(fruits.size());

    System.out.println(fruits);



  }
}
