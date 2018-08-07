package com.knoldus;

import java.time.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem5 {

    public List<Integer> getLeapYear(){

        LocalDate presentDate = LocalDate.now();
     int presentYear = presentDate.getYear();
      LocalDate givenDate = LocalDate.of(1990,07,05);
      int givenYear =  givenDate.getYear();

     List<Integer> listOfDate = IntStream.rangeClosed(givenYear,presentYear).boxed()
              .filter(year -> LocalDate.of(year,05,23).isLeapYear())
              .collect(Collectors.toList());

        return listOfDate;
    }

}
