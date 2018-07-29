
package cart
import org.scalatest.FunSuite
class ItemsBoughtSpec extends FunSuite {
  val testObj=new ItemsBought()
  test("Testing for adding medical items to cart"){
    val expected=Map("Crocin"->3,"Disprin"->4)
    val actual=testObj.getMedicalItemsQuantity()
    assert(actual===expected)
  }
  test("Testing for adding non-medical items to cart"){
    val expected=Map("Rice"->2,"Pulse"->4)
    val actual=testObj.getNonMedicalItemsQuantity()
    assert(actual===expected)
  }

}
