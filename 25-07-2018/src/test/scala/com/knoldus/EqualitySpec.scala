package com.knoldus
import org.scalatest.FunSuite
class EqualitySpec extends FunSuite {
  val testEquality1=new Point(1,2)
  val testEquality2=new Point(1,2){override val y=2}
  test("Testing For Equality "){
    assert(testEquality1==testEquality2)
  }

}
