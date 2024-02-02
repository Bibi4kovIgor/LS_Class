package edu.lemon.transformer;

import edu.lemon.generics.GenericClass;

import java.util.Arrays;

public class Launcher {
    public static void main(String[] args) {
        Double result = 0.0;
        String[] strings = {"1.23", "2.223", "1.33", "7.11"};

        Transformer<String[], Double[]> transformer = Launcher::stringToDouble;
        Double[] array = transformer.apply(strings);
        for (Double value : array) {
            result += value;
        }
        System.out.println(result);

        GenericClass<String> stringGenericClass = new GenericClass<>("some string");
        GenericClass<StringBuilder> stringsGenericClass =
                new GenericClass<>(new StringBuilder("some string").append("another string"));

        GenericClass<Integer> integerGenericClass = new GenericClass<>(1324);

        System.out.println(Arrays.toString(getByteCode(integerGenericClass)));

        System.out.println(Arrays.toString(getChars(stringGenericClass)));
        System.out.println(Arrays.toString(getChars(stringsGenericClass)));
    }

    private static Double[] stringToDouble(String[] string) {
        Double[] result = new Double[string.length];
        for (int i = 0; i < string.length; i++) {
            result[i] = Double.parseDouble(string[i]);
        }
        return result;
    }


    private static char[] getChars(GenericClass<? extends CharSequence> string) {
        return string.getValue().toString().toCharArray();
    }


     private static byte[] getByteCode(GenericClass<?> number) {
        return number.getValue().toString().getBytes();
    }
}
