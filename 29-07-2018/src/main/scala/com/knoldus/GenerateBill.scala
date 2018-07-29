package com.knoldus
import cart.{DisplayCart}
class GenerateBill extends DisplayCart {

  def generateBill():Double={
    val billMedical=totalMedicalBill.sum
    val billNonMedical=totalNonMedicalBill.sum
    billMedical + billNonMedical
  }

  def totalMedicalBill():List[Int]={
    val total=for(
      itemsAvailable<-availableMedicalItems();
      itemsBought<-getMedicalItemsQuantity()
    )yield {if(itemsAvailable._1==itemsBought._1) itemsAvailable._2*itemsBought._2 else 0}
    total.toList
  }

  def totalNonMedicalBill():List[Double]={
    val total=for(
      itemsAvailable<-availableNonMedicalItems();
      itemsBought<-getNonMedicalItemsQuantity()
    )yield {if(itemsAvailable._1==itemsBought._1) itemsAvailable._2*1.25 * itemsBought._2 else 0}
    total.toList
  }

}

