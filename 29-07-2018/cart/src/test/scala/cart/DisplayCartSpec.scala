
package cart
import availableProducts.{MedicalItems, NonMedicalItems}
import org.scalatest.FunSuite
import org.scalatest.mockito.MockitoSugar
import org.mockito.Mockito.when

class DisplayCartSpec extends FunSuite with MockitoSugar {
  val testObj=new DisplayCart()
  val mockMedicalItems=mock[MedicalItems]
  val mockNonMedicalItems=mock[NonMedicalItems]
  val mockItemsBought=mock[ItemsBought]
  test("Display the total Medical Items Bought"){
    when(mockMedicalItems.availableMedicalItems()).thenReturn(Map("Paracetamol"->10,"Crocin"->11,"Disprin"->20))
    when(mockItemsBought.getMedicalItemsQuantity()).thenReturn(Map("Crocin"->3,"Disprin"->4))
     val expected=List("Item Name= " + "Crocin" + " Item Price= " + 11 + " Item Qunatity= " + 3,"Item Name= " + "Disprin" + " Item Price= " + 20 + " Item Qunatity= "+ 4)
    val actual=testObj.displayMedicalItems()
    assert(actual===expected)
  }
  test("Display the total Non Medical Items Bought"){
    when(mockNonMedicalItems.availableNonMedicalItems()).thenReturn(Map("Rice" -> 60, "Pulse" -> 80, "Flour" -> 25, "Shampoo" -> 150))
    when(mockItemsBought.getNonMedicalItemsQuantity()).thenReturn(Map("Rice"->2,"Pulse"->4))
    val expected=List("Item Name= "+"Rice"+" Item Price= " + 60+" Item Qunatity= "+2,"Item Name= "+ "Pulse"+" Item Price= " + 80+" Item Qunatity= "+4)
    val actual=testObj.displayNonMedicalItems()
    assert(actual===expected)
  }

}
