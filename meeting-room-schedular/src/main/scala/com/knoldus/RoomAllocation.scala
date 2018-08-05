
package com.knoldus
import java.sql.ResultSet

import db.{Database, InsertData}
import org.slf4j.LoggerFactory
class RoomAllocation(val db:Database,val insert:InsertData) {

  val logger = LoggerFactory.getLogger(classOf[RoomAllocation])
  val connection = db.createConnection()
  val statement = connection.createStatement

  def meetingRoomStatus(reqEmpId: Int, reqRoomId: Int, reqDuration: String, reqTime: String, reqSize: Int): AnyVal = {
    val result = statement.executeQuery(s"select * from MEETINGROOM where roomId ='$reqRoomId' or empId = '$reqEmpId' ")
    /* if (result.isEmpty) {
      insert.meetingRoomAllocation(reqEmpId, reqRoomId, reqDuration, reqTime, reqSize)
    }
    else {
      println("In else")
      println("result.next="+result.next)*/
    //if (result!=null) {
    while (result.next) {
      println("in while")
      val roomId = result.getInt("roomId")
      val empId = result.getInt("empId")
      println(roomId)
      println(empId)
      println(reqEmpId)
      println(reqRoomId)
      val time = result.getString("getTime")
      val duration = result.getString("timeDuration")
      val size = result.getInt("empSize")
      //println("in   if(roomId)
      if (empId == reqEmpId && !(roomId == reqRoomId))
        logger.info("Already applied for today.. try again tomorrow")
      else if (!(empId == reqEmpId )&& roomId == reqRoomId) {
        if (time == reqTime)
          logger.info("Not available for the requested time .. Try for some other time")
        else {
          /*insert.meetingRoomAllocation(reqEmpId, reqRoomId, reqDuration, reqTime, reqSize)
            logger.info("success")*/ ???
        }
      }


     // else insert.meetingRoomAllocation(reqEmpId, reqRoomId, reqDuration, reqTime, reqSize)
    }
  }


  def conferenceRoomStatus(roomId: Int) = {

  }
}


