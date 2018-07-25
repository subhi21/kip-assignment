package com.knoldus
import java.io.File

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
object  Futurex extends App {

  def getFilesAndFolder(directoryName: String) = Future{
    val files: File = new File(directoryName)
    val filesRes = files.listFiles
    filesRes.map(f => if (f.isFile) f.getName else {

      val s=f.getAbsoluteFile
      s:String=> {
        val files1: File = new File(s)
        val fileRes1=files1.listFiles
        fileRes1

      }.map(f1=>"/folder"+f1.getName).mkString(" ,")

    }).toList

  }



  /*def getSubFolder(str: String):Unit =Future {
    val files: File = new File(str)
    if (files.exists()) {
      val filesRes = files.listFiles
      filesRes
    }
  }*/

  val result=getFilesAndFolder("/home/knoldus/Documents/Folder1")

  result.onComplete{
    case Success(res) => println(res)
    case Failure(ex)  => println(ex.getStackTrace)
  }
  Thread.sleep(3000)

}
