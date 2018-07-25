
package com.knoldus
import java.io.File
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

object  Folder extends App {
  def getSubFolder(directory:String)=Future{
    val files=new File(directory)
    val filesList = files.listFiles
    val listoffiles=filesList.map(fileName=>fileName.getName).toList
    listoffiles
  }

  val resultList=getSubFolder("/home/knoldus/Documents/Folder1")
  resultList.onComplete {
    case Success(resultFileList) => print(resultFileList)
    case Failure(ex)=>print(ex.getStackTrace)
  }
  Thread.sleep(3000)

}
