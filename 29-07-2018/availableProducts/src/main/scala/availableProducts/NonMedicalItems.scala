package availableProducts

trait  NonMedicalItems {
  // val vat=0.025
  def availableNonMedicalItems(): Map[String, Int] = {
    val items = Map("Rice" -> 60, "Pulse" -> 80, "Flour" -> 25, "Shampoo" -> 150)
    items
  }
}