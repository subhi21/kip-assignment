
package com.knoldus;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class FileContentCount {
    public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream("/home/knoldus/Desktop/file.txt");
            DataInputStream dis = new DataInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(dis));
            String Contents ="";
            String text = "";

            while ((Contents = br.readLine()) != null) {
                text += Contents;
            }
            Stream<String> stream = Stream.of(text.toLowerCase().split("\\W+"));

            Map<String, Long> wordFreq = stream
                    .collect(Collectors.groupingBy(String::toString, Collectors.counting()));
            System.out.println(wordFreq);
        }
        catch(IOException e1){
            System.out.println(e1);
        }
    }
}