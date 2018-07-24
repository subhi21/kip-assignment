package com.knoldus

class Person(var fname:String,var lname:String,var age:Int) {

  override def equals(objPerson1: Any): Boolean = objPerson1 match {
    case that: Person => this.fname == that.fname && this.lname == that.lname && this.age == that.age
    case _ => false
  }

  def equalContent(objPerson1: Any): Boolean = objPerson1 match {
    case that: Person => this.fname == that.fname && this.lname == that.lname && this.age == that.age
    case _ => false
  }


  /*val objPerson1 = new Person("Ankita", "Srivastav", 22)
  val objPerson2 = new Person("Ankita", "Srivastav", 22)
  objPerson1 == objPerson2
  objPerson1 equals objPerson2
  objPerson1 eq objPerson2
  val coll = scala.collection.mutable.HashSet(objPerson1)
  objPerson1.fname = "sudhanshu"
  coll contains objPerson1*/
}