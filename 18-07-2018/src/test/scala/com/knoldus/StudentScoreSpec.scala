
package com.knoldus
import org.scalatest.FunSuite
class StudentScoreSpec extends FunSuite {
  val test = new StudentTest
  val studentList: List[Student] = List(Student(1, "Bob", 11, 'A'), Student(2, "Dab", 10, 'B'), Student(3, "Tab", 10, 'C'), Student(4, "Ankita", 11, 'C'))
  val studentScore: List[ScoreCard] = List(ScoreCard(1, 88.0, 72.0, 49.0), ScoreCard(2, 67.0, 78.0, 90.0), ScoreCard(3, 76.0, 47.0, 98.0), ScoreCard(4, 89.0, 87.0, 90.0))

  test("Testing for top 3 student of class") {
    val actualResult = test.top3(studentList: List[Student], studentScore: List[ScoreCard])
    val expectedResult = List((3,"Tab"), (2,"Dab"), (4,"Ankita"))
    assert(actualResult === expectedResult)

  }

  test("Testing For the subject Topper") {
    val actualResult = test.topperStudentWithMarks("subject1", studentList, studentScore)
    val expectedResult = (4,"Ankita",89.0,87.0,90.0,266.0)
    assert(actualResult === expectedResult)
  }

  test("Testing For The MarkSheet") {
    val actualResult = test.marksheet(3, studentList, studentScore)
    val expectedResult = "ID : 3  Name : Tab  MARKS :  SUBJECTS :  SUBJECT1 : 76.0 SUBJECT2 : 47.0 SUBJECT3 : 98.0 TOTAL MARKS : 221.0"
    assert(actualResult === expectedResult)
  }
}
