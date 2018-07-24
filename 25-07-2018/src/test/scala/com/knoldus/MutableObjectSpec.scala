
package com.knoldus
import org.scalatest.FunSuite
class MutableObjectSpec extends FunSuite {
  val testObjPerson1 = new Person("Ankita", "Srivastav", 22)
  val testObjPerson2 = new Person("Ankita", "Srivastav", 22)
  val testObjPerson3 = new Person("Ankita", "Srivastav", 22)
  testObjPerson1.fname="Sudhanshu"
  val coll=scala.collection.mutable.HashSet(testObjPerson1)
  test("Testing for valid input"){
    assert(testObjPerson2==testObjPerson2)
  }
  test("Testing for mutable object"){
    assert(coll contains testObjPerson1)
  }


}
