package com.knoldus
import org.scalatest.FunSuite
class UrlExtractorSpec extends FunSuite {
 val test=new URL()
  test("Testing for valid input"){
    val actualResult=test.extractor("https://aws.amazon.com/console/home?state=hash&isauthcode=true&code=112")
    val expextedResult="protocol= https\ndoamin= aws.amazon.com\npath= console/home\nparams= Map(state -> hash, isauthcode -> true, code -> 112)"

    assert(actualResult===expextedResult)
  }
test("testing for invalid input"){

}
}
