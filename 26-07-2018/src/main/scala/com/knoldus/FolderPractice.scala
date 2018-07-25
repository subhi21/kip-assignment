
package com.knoldus
import java.io.File
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
object  FolderPractice extends App {

  def getFilesAndFolder(directoryName: String) = Future {
    val files: File = new File(directoryName)
    val fileList = files.listFiles
    print(fileList.map(f => if (f.isFile) f.getName else {

      var fileArray = getSubFolder(f.getAbsolutePath)
      fileArray.map(file => "Folder3/" + file.getName).mkString(", ")
    }).toList)


    def getSubFolder(value: String): Array[File] = {
      val files: File = new File(value)
      if (files.exists()) {
        val fileList = files.listFiles
        fileList
      }
      else
        Array[File]()

    }
  }
  val result=getFilesAndFolder("/home/knoldus/Documents/Folder1")
  result.onComplete{
    case Success(listOfFiles) => println(listOfFiles)
    case Failure(ex)  => println(ex.getStackTrace)
  }
  Thread.sleep(4000)
}

