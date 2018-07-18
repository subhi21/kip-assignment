package com.knoldus
import org.scalatest.FunSuite
class PatternToStringSpec extends FunSuite {
  val testObj = new PatternToString()
  val objCaseClass = Pet("Tommy", "Dog")
  test("Testing for String Value") {
    val actualResult = testObj.returnString("Ankita")
    val expectedResult = "You gave me this string: Ankita"
    assert(actualResult === expectedResult)
  }
  test("Testing for Integer Value") {
    val actualResult = testObj.returnString(5)
    val expectedResult = "thanks for the int: 5"
    assert(actualResult === expectedResult)
  }
  test("Testing for Float Value") {
    val actualResult = testObj.returnString(5.0f)
    val expectedResult = "Thanks for the float: 5.0"
    assert(actualResult === expectedResult)
  }
  test("Testing for Array[Int]") {
    val actualResult = testObj.returnString(Array(1, 2, 3, 4, 5))
    val expectedResult = "An array of int: 1,2,3,4,5"
    assert(actualResult === expectedResult)
  }
  test("Testing for Array[String]") {
    val actualResult = testObj.returnString(Array("Apple", "Orange", "Banana"))
    val expectedResult = "An array of Stirng: Apple,Orange,Banana"
    assert(actualResult === expectedResult)
  }
  test("Testing for Pet") {
    val actualResult = testObj.returnString(objCaseClass)
    val expectedResult = "Tommy is a good pet"
    assert(actualResult === expectedResult)
  }
  test("Testing for List[Any]") {
    val actualResult = testObj.returnString(List(1, 2, 3, 4))
    val expectedResult = "Thanks for the List: List(1, 2, 3, 4)"
    assert(actualResult === expectedResult)
  }
  test("Testing for Map") {
    val actualResult = testObj.returnString(Map(1 -> "One", 2 -> "Two", 3 -> "Three"))
    val expectedResult = "Map(1 -> One, 2 -> Two, 3 -> Three)"
    assert(actualResult === expectedResult)
  }
}




