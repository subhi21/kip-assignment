
package com.knoldus;


import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


public class ClassRoom {

    private int roomId;
    private Optional <List<Student>> studentList;
    public ClassRoom(int roomId,Optional<List<Student>> listOfStudent){
        this.roomId=roomId;
        this.studentList=listOfStudent;
    }
    public int getRoomId(){
        return this.roomId;
    }
    public  Optional<List<Student>> getStudentList(){
        return this.studentList;
    }
}


class Student{

   private String name;
   private int rollNo;
   private Optional<List<String>> subject;
   public Student(String name,int rollNo,Optional<List<String>> list){
       this.name=name;
       this.rollNo=rollNo;
       this.subject=list;
   }
   public String getName(){
       return  this.name;
   }
   public Integer getRollNo(){
       return this.rollNo;
   }
   public Optional<List<String>> getSubject(){


           return this.subject;

   }

}
class ClassRoomProgram {


        public List<String> getStudent(List<ClassRoom> roomList){
            List<ClassRoom> classRoomWithStudent = roomList.stream().filter(room -> room.getStudentList().isPresent())
                    .collect(toList());

            List<List<Student>> studentList = classRoomWithStudent.stream()
                    .map(list -> list.getStudentList().get())
                    .collect(toList());


            return studentList.stream().flatMap(students -> students.stream())
                    .filter(student -> !student.getSubject().isPresent())
                    .map(student -> student.getName())
                    .collect(Collectors.toList());


        }
        public List<String> getSubject(List<ClassRoom> roomList,int roomId){

        List<ClassRoom> classRoomWithStudents = roomList.stream()
                    .filter(room -> room.getStudentList().isPresent() && roomId==(room.getRoomId()))
                    .collect(Collectors.toList());

            List<List<Student>> studentslist = classRoomWithStudents.stream()
                    .map(list -> list.getStudentList().get())
                    .collect(Collectors.toList());

            List<Student> studentsWithSubjects = studentslist.stream().flatMap(Collection::stream)
                    .filter(student -> student.getSubject().isPresent())
                    .collect(toList());

            List<List<String>> subjectsOfRequiredStudents = studentsWithSubjects.stream()
                    .map(student -> student.getSubject().get())
                    .collect(Collectors.toList());

            return subjectsOfRequiredStudents.stream().flatMap(Collection::stream)
                    .collect(Collectors.toList());
        }

        public String helloStudent(List<ClassRoom> roomList,int roomId){
            List<ClassRoom> classRoomWithStudents =  roomList.stream()
                    .filter(classRoom -> classRoom.getStudentList().isPresent())
                    .collect(Collectors.toList());
            if(classRoomWithStudents.stream().anyMatch(room -> (roomId==room.getRoomId())))
                return "Hello Students";
            else
                return "No students";
        }
    }



