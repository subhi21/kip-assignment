package com.knoldus

import cart.{CustomerDetails,DisplayCart}

class DisplayBill extends GenerateBill with CustomerDetails {
   def NameAndNumber(): String = {
    "Name =Ankita Srivastav" + "Phone Number=7376465404"
  }


  def displayBill(): String={

    val details=NameAndNumber
    val listMedical=displayMedicalItems
    val listNonMedical=displayNonMedicalItems()
    val totalBill=generateBill()
    s"$details :\n $listMedical : \n $listNonMedical :\n Toatal Payable Amount  $totalBill"

  }
}
/*object  d extends App{
  val v=new DisplayBill()
  v.displayBill()
}*/