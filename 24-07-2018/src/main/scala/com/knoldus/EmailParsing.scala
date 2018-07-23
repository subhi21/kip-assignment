package com.knoldus

object EmailParsing {
  def apply(user:String,domain:String): String = {
    val email = user + "@" + domain
    val regEmail = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])".r
    if (regEmail.findAllIn(email).isEmpty)
      "Not valid Email"
    else
      email
  }

  def unapply(email:String): Option[(String,String)]= {
    val parts=email.split("@")
    if(parts.length==2)
      Some(parts(0),parts(1))
    else
    None

  }
}
class Email {
  EmailParsing("knol", "knoldus.com")

  def extractor(email: String): String = email match {

    case EmailParsing(user, domain) => "user=" + user + "\ndomain=" + domain
    case _ => "Not a valid Email"


  }
}

