package com.knoldus;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import com.knoldus.ClassRoom;
import com.knoldus.Student;
import com.knoldus.ClassRoomProgram;

public class TestProblem {
    public static void main(String[] args) {

        Problem2 problem2Obj = new Problem2();
        Problem3 problem3Obj = new Problem3();
        Problem4 problem4Obj = new Problem4();
        Problem5 problem5Obj = new Problem5();

            Student student1 = new Student("Ankita",1,Optional.ofNullable(Arrays.asList("English","Hindi","Maths","Chemistry")));
            Student student2 = new Student("Anubha",2,Optional.ofNullable(null));
            Student student3 = new Student("Amita",3,Optional.ofNullable(Arrays.asList("English","Hindi","Maths","Chemistry")));
            Student student4 = new Student("Ankit",4,Optional.ofNullable(Arrays.asList("English","Hindi","Maths","Chemistry")));
            Student student5 = new Student("Sudhanshu",5,Optional.ofNullable(null));

            ClassRoom room1 = new ClassRoom(10, Optional.ofNullable(Arrays.asList(student1,student2)));
            ClassRoom room2 = new ClassRoom(11, Optional.ofNullable(Arrays.asList(student3,student4)));
            ClassRoom room3 = new ClassRoom(12, Optional.ofNullable(null));
            ClassRoom room4 = new ClassRoom(13, Optional.ofNullable(null));
            ClassRoom room5 = new ClassRoom(14, Optional.ofNullable(Arrays.asList(student5)));
            List<ClassRoom> listOfClassRoom = Arrays.asList(room1,room2,room3,room4,room5);
            ClassRoomProgram roomObj = new ClassRoomProgram();
            System.out.println(roomObj.getStudent(listOfClassRoom));
            System.out.println(roomObj.getSubject(listOfClassRoom,11));
            System.out.println(roomObj.helloStudent(listOfClassRoom,10));


            List<String> listOfBirthday = problem2Obj.getAllBirthdays();
            Long durationLife = problem4Obj.getDurationOfMahtmaGandhi();
            List<Integer> listOfLeapYears = problem5Obj.getLeapYear();
        ZonedDateTime zonedDateTime = problem3Obj.getTimeFromTimeZone("America/Los_Angeles");

            System.out.println("Ansewr of problem2 List of birthdays: "+listOfBirthday);
            System.out.println("Answer of problem4 Life of Mahatma Gandhi "+durationLife);
            System.out.println("Ansewr of problem5 List of leap years :"+listOfLeapYears);
            System.out.println("Time as per given zone : "+zonedDateTime);



    }

}
