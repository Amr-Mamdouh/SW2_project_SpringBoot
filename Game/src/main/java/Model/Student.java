package Model;

//import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DB.DB_Connection;

public class Student extends Person { 
	double rate;
	String Pass="";
	static  int num=1;
	  private static Connection cdb=null;
	    Statement mystmnt=null;
	    public String getPass() {
			return Pass;
		}
		public void setPass(String pass) {
			Pass = pass;
		}

		DB_Connection db=null;
	    ArrayList<String> course=new ArrayList<String>();
	    ArrayList<String> games=new ArrayList<String>();
	    public Student() {
			super();
			this.rate = 0;
			this.mystmnt =null ;
			this.db = null;
			this.course = null;
			this.games = null;
		}
	public Student(double rate, Statement mystmnt, DB_Connection db, ArrayList<String> course,
				ArrayList<String> games) {
			super();
			this.rate = rate;
			this.mystmnt = mystmnt;
			this.db = db;
			this.course = course;
			this.games = games;
		}
	public int  login(String user,String pass)
	{
		System.err.println("LoginPhase");
		try {
		 cdb=db.getconnection();
		 if(cdb==null)
			 return -1;
		 else
		 {mystmnt= cdb.createStatement();
		 
		 
		 ResultSet myres=mystmnt.executeQuery("select  S_ID from student where email="+user+" and pass="+pass);
		 if (myres==null)
			 return -1 ;
		 else {
			 System.out.println(myres.getInt("S_ID"));
			 return myres.getInt("S_ID");
				 }
		 }
			
		} catch (Exception ex) {
			return -1 ;
			
		}
	}
	public ArrayList<String> getcourse(int user_ID)
	{
try {
	cdb=db.getconnection();
	 if(cdb==null)
		 return null;
	 else
	 {mystmnt= cdb.createStatement();
	 
	 
	 ResultSet myres=mystmnt.executeQuery("select  C_name from course where C_ID in (select C_ID from studentcourses where S_ID="+user_ID+")");
	 if (myres==null)
		 return null ;
	 else {

		 while (myres.next())
		 	{
			 System.out.println(myres.getInt("C_Name"));

			 course.add(myres.getString("C_name"));
		 	}
		 }
			 }

	return course;
	
} catch (Exception e) {
	return null;
}
	
	}
	public int createstudent(String name,String email,String pass,char gender,String phone,int age)
	{
		try {
			cdb=db.getconnection();
		
		 if(cdb==null)
			 return -1;
		 else
		 {mystmnt= cdb.createStatement();
		 String s="'"+name+"',"+age+",'"+gender+"','"+phone+"','"+email+"','"+pass+"',"+(3000+num);
		 num++;
		 int myres=mystmnt.executeUpdate("insert into student (s_name,age,gender,phone,email,pass,S_ID) value("+s+")");
		 if(myres==-1)
			 return -1;
		 else return (3000+num-1);
		 }
		} catch (Exception ex) {
			return -1;
		}
	}

public ArrayList<String> getgames(int c_id)
{
try {
cdb=db.getconnection();
 if(cdb==null)
	 return null;
 else
 {mystmnt= cdb.createStatement();
 
 
 ResultSet myres=mystmnt.executeQuery("select g_name from game where course="+c_id);
 if (myres==null)
	 return null ;
 else {
	 System.out.println(myres.getInt("g_name"));

	 while (myres.next())
	 	{
		 games.add(myres.getString("g_name"));
	 	}
	 }
		 }

return course;

} catch (Exception e) {
return null;
}


}

}
