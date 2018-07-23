package com.knoldus

object URLExtractor {
  def apply(protocol: String, domain: String, path: String, params: Map[String, String]): String = {
    protocol + "://" + domain + path + "?" + params.map(ele => ele._1 + "=" + ele._2 + "&").mkString("")

  }

  def check(str:Array[String]):Boolean= {
    if(str.length==2) true
    else false

  }



  def unapply(url: String): Option[(String, String, String, Map[String, String])] = {
    val parts = url.split("://")
    val domain = parts(1).split("/", 2)
    val path = domain(1).split("\\?")
    val params = path(1).split("&").map(v => {
      val m = v.split("=")
      m(0) -> m(1)
    }).toMap
    if(check(parts) && check(domain) && check(path))
    Some(parts(0), domain(0), path(0), params)
    else
      None

  }

}
class URL{

    URLExtractor("https", "aws.amazon.com", "/console/home", Map("state" -> "hash", "isauthcode" -> "true", "code" -> "112"))

  def extractor(str:String):String= str match{
    case URLExtractor(protocol,domain,path,params)=>"protocol= "+protocol+"\ndoamin= "+domain+"\npath= "+path+"\nparams= "+params
    case _=>"String not valid"

  }
}
 object t {
   def main(args: Array[String]): Unit = {
     val tset = new URL()
     println(tset.extractor("https://aws.amazon.com/console/home?state="))
   }
 }