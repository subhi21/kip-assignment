package com.knoldus;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordFrequency {

    public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the String");
      String text=sc.nextLine();
      WordFrequency worObj=new WordFrequency();
      Map <String,Long> wordCount=worObj.countFrequency(text);
     System.out.println( wordCount.keySet().stream()
              .map(key -> Arrays.asList(key,wordCount.get(key)))
              .collect(Collectors.toList()));

    }
    public Map<String,Long> countFrequency(String text){
        Stream<String> stream = Stream.of(text.toLowerCase().split("\\W+"));

        Map<String, Long> wordFreq = stream
                .collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        return wordFreq;
    }
}
