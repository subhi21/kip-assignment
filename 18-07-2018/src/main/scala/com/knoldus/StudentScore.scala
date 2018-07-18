package com.knoldus

case class Student(Id:Int, name:String,division:Int,section:Char)

case class ScoreCard(Id:Int,totalMark:Double,subject1:Double,subject2 :Double,subject3:Double)

object ScoreCard{
  def apply(studentId:Int,subject1:Double,subject2:Double,subject3:Double): ScoreCard ={
    val totalMark=subject1+subject2+subject3
    new ScoreCard(studentId,totalMark, subject1,subject2,subject3)
  }
}

class StudentTest {

  def top3(studentList: List[Student], studentScore: List[ScoreCard]):List[Any]={

      val top3List = studentScore.sortWith(_.totalMark < _.totalMark).takeRight(3).map(_.Id)
      val topperName = top3List.map {
      sid => studentList.filter(_.Id == sid).head
    }
   topperName.map(ele=>(ele.Id,ele.name))
  }


  def topperStudentWithMarks(subject:String,studentList: List[Student], studentScore: List[ScoreCard]):(Int, String, Double, Double, Double, Double) = {

    val subjectTopper = subject match {
      case "subject1" => studentScore.sortWith (_.subject1 > _.subject1).head
      case "subject2" => studentScore.sortWith (_.subject2 > _.subject2).head
      case "subject3" => studentScore.sortWith (_.subject3 > _.subject3).head
    }
    val topperDetails = studentList.filter(_.Id == subjectTopper.Id).head
     (subjectTopper.Id, topperDetails.name, subjectTopper.subject1, subjectTopper.subject2, subjectTopper.subject3, subjectTopper.totalMark)
  }
  def marksheet(sid:Int,studentList: List[Student], studentScore: List[ScoreCard]):String ={

    val scoreCard = studentScore.filter(_.Id == sid).head
    val studentInfo = studentList.filter(_.Id == sid).head
    s"ID : $sid " +
      s" Name : ${studentInfo.name} " +
      s" MARKS : " +
      s" SUBJECTS : " +
      s" SUBJECT1 : ${scoreCard.subject1}" +
      s" SUBJECT2 : ${scoreCard.subject2}" +
      s" SUBJECT3 : ${scoreCard.subject3}" +
      s" TOTAL MARKS : ${scoreCard.totalMark}"


    }


}

