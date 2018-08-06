
package com.knoldus;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumber {
    static int pick;

    public static void main(String[] args) {

        List<Integer> list = new Random().ints(0, 100).limit(100)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(list.stream()
                .filter(PrimeNumber::isPrime)
                .collect(Collectors.toList()));
    }

    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number/2)
                .noneMatch(i -> number%i == 0);
    }
}
