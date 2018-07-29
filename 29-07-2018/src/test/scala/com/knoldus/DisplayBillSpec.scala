
package com.knoldus
import cart.DisplayCart
import org.scalatest.FunSuite
import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito.when

class DisplayBillSpec extends FunSuite with MockitoSugar {
  val testObj=new DisplayBill()
  val mockDisplayCart=mock[DisplayCart]
  val mockGenerateBill=mock[GenerateBill]
  test("Displaying the Bill"){
    when(mockDisplayCart.displayNonMedicalItems()).thenReturn(List("Item Name= "+"Rice"+" Item Price= " + 60+" Item Qunatity= "+2,"Item Name= "+ "Pulse"+" Item Price= " + 80+" Item Qunatity= "+4))
    when(mockDisplayCart.displayMedicalItems()).thenReturn(List("Item Name= "+"Crocin"+" Item Price= " + 11+" Item Qunatity= "+3,"Item Name= "+ "Disprin"+" Item Price= " + 20+" Item Qunatity= "+4))
    val expected="Name =Ankita Srivastav Phone Nume=7376465404  : \nList(Item Name= Crocin Item Price= 11 Item Qunatity= 3, Item Name= Disprin Item Price= 20 Item Qunatity= 4) :\nList(Item Name= Rice Item Price= 60 Item Qunatity= 2, Item Name= Pulse Item Price= 80 Item Qunatity= 4) :\nToatal Payable Amount  663.0"
    val actual=testObj.displayBill()
    assert(actual===expected)
  }
  test("testing for customer name and number"){
    val expected="Name =Ankita Srivastav" + "Phone Number=7376465404"
    val actual=testObj.NameAndNumber()
    assert(actual===expected)
  }


}
