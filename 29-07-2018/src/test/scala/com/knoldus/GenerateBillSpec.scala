
package com.knoldus
import availableProducts.{MedicalItems, NonMedicalItems}
import cart.ItemsBought
import org.scalatest.FunSuite
import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito.when
class GenerateBillSpec extends FunSuite with MockitoSugar {
  val testObj=new GenerateBill()
  val mockMedicalItems=mock[MedicalItems]
  val mockNonMedicalItems=mock[NonMedicalItems]
  val mockItemsBought=mock[ItemsBought]
  test("Testing for Generating Bill of medical Items"){
    when(mockMedicalItems.availableMedicalItems()).thenReturn(Map("Paracetamol"->10,"Crocin"->11,"Disprin"->20))
    when(mockItemsBought.getMedicalItemsQuantity()).thenReturn(Map("Crocin"->3,"Disprin"->4))
    val expected=List(0,0,33,0,0,80)
      val actual=testObj.totalMedicalBill
    assert(actual==expected)
  }
 test("Testing for Generating Non-medicalBill of medical Items"){
    when(mockNonMedicalItems.availableNonMedicalItems()).thenReturn(Map("Rice" -> 60, "Pulse" -> 80, "Flour" -> 25, "Shampoo" -> 150))
    when(mockItemsBought.getNonMedicalItemsQuantity()).thenReturn(Map("Rice"->2,"Pulse"->4))
    val expected=List(150.0,0.0,0.0,400,0.0,0.0,0.0,0.0)
    val actual=testObj.totalNonMedicalBill
    assert(actual==expected)
  }
  test("Testing for generating total Bill"){
    val expected=663
    val actual=testObj.generateBill
    assert(actual===expected)
  }


}
