
package db

class InsertData(val database: Database) {
  val connection = database.createConnection()
  val statement = connection.createStatement
  def insertEmployeeDetails(empId: Int, empName: String, empNumber: String): Unit = {

    statement.executeUpdate("insert into EMPLOYEEDETAILS values('"+empId+"','"+empName+"',"+empNumber+")")

  }
  def insertRoomDetails():Unit={
    statement.executeUpdate("insert into ROOMDETAILS values(1,'Divine','Normal')")
    statement.executeUpdate("insert into ROOMDETAILS values(2,'Hope','Normal')")
    statement.executeUpdate("insert into ROOMDETAILS values(3,'Success','Normal')")
    statement.executeUpdate("insert into ROOMDETAILS values(4,'Coders','Normal')")
    statement.executeUpdate("insert into ROOMDETAILS values(5,'Knol-Room','Normal')")
    statement.executeUpdate("insert into ROOMDETAILS values(6,'Conference-Hall','Conference')")

  }

  def meetingRoomAllocation(empId:Int,roomId:Int,duration:String,time:String,size:Int)={
    statement.executeUpdate("insert into MEETINGROOM values('"+empId+"','"+roomId+"',"+duration+",'"+time+"','"+size+"')")
    //statement.executeUpdate("insert into MEETINGROOM values(2,'Hope','Normal')")


  }
}
/*object t extends App{
  val d=new Database
  val i =new InsertData(d)
  i.meetingRoomAllocation()
}*/
