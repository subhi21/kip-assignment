package com.knoldus;

import java.time.*;

public class Problem3 {

    public ZonedDateTime getTimeFromTimeZone(String timeZone){

        Instant timeStamp= Instant.now();
       ZonedDateTime zonedDateTime =  timeStamp.atZone(ZoneId.of(timeZone));
        ZonedDateTime timestampAtGMTPlus1= timeStamp.atZone(ZoneId.of("UTC+12:00"));
        System.out.println("In 'GMT+01:00' Time Zone:"+ timestampAtGMTPlus1);

      return zonedDateTime;
    }

}
