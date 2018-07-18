
package com.knoldus

class PatternMatchingList {

  def max(list:List[Int]):Int=list match{
    case Nil=> throw new NoSuchElementException
    case List(a:Int)=> a
    case a::b::rest=>max((if(a>b) a else b) :: rest)
  }

  def length(list:List[Int]):Int=list match{
    case Nil=>0
    case _::tail=>1+length(tail)
  }

  def nthLast(n:Int,list:List[Int]):Int=list match {
    case tail if (tail.length == n) => tail.head
    case (_ :: tail) => nthLast(n, tail)
    case _ => throw new NoSuchElementException
  }

  def min(list:List[Int]):Int=list match{
    case Nil=> throw new NoSuchElementException
    case List(a:Int)=> a
    case a::b::rest=>min((if(a<b) a else b) :: rest)
  }


}
