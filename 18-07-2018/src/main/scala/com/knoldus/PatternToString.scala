package com.knoldus

class PatternToString {
  def returnString(valType: Any): String = valType match {
    case s: String => s"You gave me this string: $s"
    case i: Int => s"thanks for the int: $i"
    case f: Float => s"Thanks for the float: $f"
    case a: Array[Int] => s"An array of int: ${a.mkString(",")}"
    case as: Array[String] => s"An array of Stirng: ${as.mkString(",")}"
    case d: Pet => s"${d.name} is a good pet"
    case list: List[_] => s"Thanks for the List: ${list.toString}"
    case m: Map[_, _] => m.toString
  }

}
case class Pet(name:String,animal:String){}




