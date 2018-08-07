package com.knoldus;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class Problem4 {

    public Long getDurationOfMahtmaGandhi(){
        LocalDate birthDate = LocalDate.of(1869,10,02);
        LocalDate deathDate = LocalDate.of(1948,01,30);
        long days = ChronoUnit.DAYS.between(birthDate,deathDate);
      long seconds = days*24*60*60;
      return seconds;

    }


}
