package DB;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DB_Connection {
	 static boolean active=false;
     private static Connection cdb=null;
    static Statement mystmnt=null;
   
  private  static void db()
  {  
   try {
          // The newInstance() call is a work around for some
          // broken Java implementations

        Class.forName("com.mysql.jdbc.Driver");
         cdb = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamestudent"
							, "root","root");       
         
                   mystmnt=(Statement) cdb.createStatement();
                 active=true;
               /* ResultSet myres=((java.sql.Statement) mystmnt).executeQuery("select *  FROM registration");
while(myres.next()){
                System.out.println(myres.getString("Student_Name"));
                 System.out.println(myres.getString("Course_Name"));
                 System.out.println(myres.getString("Student_ID"));
                System.out.println(myres.getString("Year"));

}*/
      } catch (Exception ex) {
          // handle the error
          System.err.println("Error");
      }
  
    
  }
  public Connection getconnection()
  {
	  if(active==true)
		  return cdb;
	  else 
	  {
		db();
		if (active==true)
			return cdb;
		else return null;
	  }
	  
  }
}
