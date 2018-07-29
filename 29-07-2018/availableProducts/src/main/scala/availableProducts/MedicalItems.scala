package availableProducts

trait MedicalItems {
  //val vat=0.0
  def availableMedicalItems():Map[String,Int]={
    val items=Map("Paracetamol"->10,"Crocin"->11,"Disprin"->20)
    items
  }
}