
package com.knoldus;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problem2 {
    public List<String> getAllBirthdays(){

        LocalDate birthDate = LocalDate.of(1995,04,28);
        LocalDate presentDate = LocalDate.of(2018,04,28);

        int birthYear = birthDate.getYear();
        int presentYear = presentDate.getYear();

       List<String> list= IntStream.rangeClosed(birthYear,presentYear).boxed()
                .map(year -> LocalDate.of(year,04,28).getDayOfWeek().toString())
                .collect(Collectors.toList());

       return list;

    }

}

