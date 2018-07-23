package com.knoldus
import org.scalatest.FunSuite
class EmailParsingSpec extends FunSuite {
  val test=new Email()
  test("tseting for valid input of email"){
    val actualResult=test.extractor("knol@knoldus.in")
    val expectedResult="user=knol\ndomain=knoldus.in"
    assert(actualResult===expectedResult)
  }
  test("testing for invalid email"){

    val actualResult=test.extractor("knol@")
    val expectedResult="Not a valid Email"
    assert(actualResult===expectedResult)
  }


}
