package Model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DB.DB_Connection;
public class Teacher extends Person{
	static  int num=1;
	  private static Connection cdb=null;
	    Statement mystmnt=null;
	    DB_Connection db=null;
	    static int cnum=1,gnum=1;
	    ArrayList<String> course=new ArrayList<String>();
	    
	    ArrayList<String> games=new ArrayList<String>();
	    
	    public Teacher() {
			super();
			this.mystmnt = null;
			this.db =null;
			this.course = null;
			this.games = null;
		}
	public Teacher(Statement mystmnt, DB_Connection db, ArrayList<String> course, ArrayList<String> games) {
			super();
			this.mystmnt = mystmnt;
			this.db = db;
			this.course = course;
			this.games = games;
		}

	public int  login(String user,String pass)
	{
		try {
		 cdb=db.getconnection();
		 if(cdb==null)
			 return -1;
		 else
		 {mystmnt= cdb.createStatement();
		 
		 
		 ResultSet myres=mystmnt.executeQuery("select  T_ID from teacher where email="+user+" and pass="+pass);
		 if (myres==null)
			 return -1 ;
		 else {
			 System.out.println(myres.getInt("T_ID"));

			 return myres.getInt("T_ID");
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
	 
	 
	 ResultSet myres=mystmnt.executeQuery("select  C_name from course where T_ID="+user_ID);
	 if (myres==null)
		 return null ;
	 else {
		 System.out.println(myres.getInt("T_ID"));

		 while (myres.next())
		 	{
			 course.add(myres.getString("C_name"));
		 	}
		 }
			 }

	return course;
	
} catch (Exception e) {
	return null;
}
	

	}
public int createTeacher(String name,String email,String pass,char gender,String phone,int age)
{
	try {
		cdb=db.getconnection();
	
	 if(cdb==null)
		 return -1;
	 else
	 {mystmnt= cdb.createStatement();
	 String s="'"+name+"',"+age+",'"+gender+"','"+phone+"','"+email+"','"+pass+"',"+(1000+num);
	 num++;
	 int myres=mystmnt.executeUpdate("insert into teacher (t_name,age,gender,phone,email,pass,T_ID) value("+s+")");
	 if(myres==-1)
		 return -1;
	 else return (1000+num-1);
	 }
	} catch (Exception ex) {
		return -1;
	}
}
public int createCourse(String name ,int T_id)
	{
		try {
				cdb=db.getconnection();
			
			 if(cdb==null)
				 return -1;
			 else
			 	{	mystmnt= cdb.createStatement();
			 		String s="'"+name+"',"+T_id+","+2000+cnum;
			 		cnum++;
			 		int myres=mystmnt.executeUpdate("insert into course (C_name,T_ID,C_ID) value("+s+")");
			 		if(myres==-1)
			 			return -1;
			 		else return (2000+cnum-1);
			 	}
			 } 
		catch (Exception ex) {
			return -1;
		}
	}

}
