package cart
class  ItemsBought {
  def getMedicalItemsQuantity():Map[String,Int]={
    val medicalItems=Map("Crocin"->3,"Disprin"->4)
    medicalItems
  }

  def getNonMedicalItemsQuantity():Map[String,Int]={
    val nonMedicalItems=Map("Rice"->2,"Pulse"->4)
    nonMedicalItems
  }

}
