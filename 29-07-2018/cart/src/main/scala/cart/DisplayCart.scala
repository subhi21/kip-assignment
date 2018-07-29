package cart
import availableProducts.{MedicalItems,NonMedicalItems}
class DisplayCart extends ItemsBought with MedicalItems with NonMedicalItems {

  def displayMedicalItems():List[Any]={
    val items=for(
      itemsAvailable<-availableMedicalItems();
      itemsBought<-getMedicalItemsQuantity()
      if(itemsAvailable._1==itemsBought._1)
    )yield { "Item Name= " + itemsAvailable._1 + " Item Price= " + itemsAvailable._2 + " Item Qunatity= " + itemsBought._2}
    items.toList
  }
  def displayNonMedicalItems():List[Any]={
    val items=for(
      itemsAvailable<-availableNonMedicalItems();
      itemsBought<-getNonMedicalItemsQuantity()
      if(itemsAvailable._1==itemsBought._1)
    )yield { "Item Name= " + itemsAvailable._1 +" Item Price= " + itemsAvailable._2 +" Item Qunatity= " + itemsBought._2}
    items.toList
  }

}
