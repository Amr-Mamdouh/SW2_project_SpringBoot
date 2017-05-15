package Model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import DB.DB_Connection;

public class game {
	
	String G_name , G_description;
	int c_id,t_id;
	String G_category;
	private int id;
	 private static Connection cdb=null;
	    Statement mystmnt=null;
	    DB_Connection db=null;
	    
	    static int gnum=1,qnum=1;
	    ArrayList<String> games=new ArrayList<String>();
	    ArrayList<String> course=new ArrayList<String>();
	    ArrayList<String> true_question=new ArrayList<String>();
	    ArrayList<String> multiple_question=new ArrayList<String>();



		public game() {
			super();
			this.mystmnt = mystmnt;
			this.db = db;
			this.games = games;
			this.course = course;
			this.true_question = true_question;
			this.multiple_question = multiple_question;
		}


		public game(Statement mystmnt, DB_Connection db, ArrayList<String> games, ArrayList<String> course,
				ArrayList<String> true_question, ArrayList<String> multiple_question) {
			super();
			this.mystmnt = mystmnt;
			this.db = db;
			this.games = games;
			this.course = course;
			this.true_question = true_question;
			this.multiple_question = multiple_question;
		}


		public String getG_name() {
			return G_name;
		}


		public void setG_name(String g_name) {
			G_name = g_name;
		}


		public String getG_description() {
			return G_description;
		}


		public void setG_description(String g_description) {
			G_description = g_description;
		}


		public int getC_id() {
			return c_id;
		}


		public void setC_id(int c_id) {
			this.c_id = c_id;
		}


		public int getT_id() {
			return t_id;
		}


		public void setT_id(int t_id) {
			this.t_id = t_id;
		}


		public String getG_category() {
			return G_category;
		}


		public void setG_category(String g_category) {
			G_category = g_category;
		}


		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public static Connection getCdb() {
			return cdb;
		}


		public static void setCdb(Connection cdb) {
			game.cdb = cdb;
		}


		public Statement getMystmnt() {
			return mystmnt;
		}


		public void setMystmnt(Statement mystmnt) {
			this.mystmnt = mystmnt;
		}


		public DB_Connection getDb() {
			return db;
		}


		public void setDb(DB_Connection db) {
			this.db = db;
		}


		public static int getGnum() {
			return gnum;
		}


		public static void setGnum(int gnum) {
			game.gnum = gnum;
		}


		public static int getQnum() {
			return qnum;
		}


		public static void setQnum(int qnum) {
			game.qnum = qnum;
		}


		public ArrayList<String> getGames() {
			return games;
		}


		public void setGames(ArrayList<String> games) {
			this.games = games;
		}


		public ArrayList<String> getCourse() {
			return course;
		}


		public void setCourse(ArrayList<String> course) {
			this.course = course;
		}


		public ArrayList<String> getTrue_question() {
			return true_question;
		}


		public void setTrue_question(ArrayList<String> true_question) {
			this.true_question = true_question;
		}


		public ArrayList<String> getMultiple_question() {
			return multiple_question;
		}


		public void setMultiple_question(ArrayList<String> multiple_question) {
			this.multiple_question = multiple_question;
		}


		public int creategame(String name ,String description,int c_id,int t_id,String category)
	    {
	    	try {
	    			cdb=db.getconnection();
	    		
	    		 if(cdb==null)
	    			 return -1;
	    		 else
	    		 	{	mystmnt= cdb.createStatement();
	    		 		String s="'"+name+"',"+c_id+",'"+category+"',"+t_id+","+4000+gnum+",'"+description+"'";
	    		 		gnum++;
	    		 		int myres=mystmnt.executeUpdate("insert into game (g_name,course,category,T_ID,G_ID,description) value ("+s+")");
	    		 		if(myres==-1)
	    		 			return -1;
	    		 		else return (4000+gnum-1);
	    		 	}
	    		 } 
	    	catch (Exception ex) {
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

	return games;

	} catch (Exception e) {
	return null;
	}


	}

	public ArrayList<String> getcourse()
	{
try {
	cdb=db.getconnection();
	 if(cdb==null)
		 return null;
	 else
	 {mystmnt= cdb.createStatement();
	 
	 
	 ResultSet myres=mystmnt.executeQuery("select  C_name,C_ID from course");
	 if (myres==null)
		 return null ;
	 else {
		 System.out.println(myres.getInt("T_ID"));

		 while (myres.next())
		 	{
			 course.add(myres.getString("C_name"));
			 course.add(myres.getString("C_ID"));
		 	}
		 }
			 }

	return course;
	
} catch (Exception e) {
	return null;
}
	

	}
public boolean addtrue_question(String question ,String answer,int g_id)
	{
	try{
	cdb=db.getconnection();
	
	 if(cdb==null)
		 return false;
	 else
	 	{	mystmnt= cdb.createStatement();
	 		String s="'"+question+"','"+answer+"',"+g_id+","+5000+qnum;
	 		qnum++;
	 		int myres=mystmnt.executeUpdate("insert into truequestion (Question,answer,G_ID,Q_ID) value ("+s+")");
	 		if(myres==-1)
	 			return false;
	 		else return true;
	 	}
	 } 
catch (Exception ex) {
	return false;
}

	}

public ArrayList<String> gettrue_question(int g_id)
{
try {
cdb=db.getconnection();
 if(cdb==null)
	 return null;
 else
 {mystmnt= cdb.createStatement();
 
 
 ResultSet myres=mystmnt.executeQuery("select Question,answer from truequestion where G_ID="+g_id);
 if (myres==null)
	 return null ;
 else {

	 while (myres.next())
	 	{
		 true_question.add(myres.getString("Question"));
		 true_question.add(myres.getString("answer"));
	 	}
	 }
		 }

return true_question;

} catch (Exception e) {
return null;
}


}
public boolean add_Multiple_question(String question ,String A,String B,String C,String D,char answer,int g_id)
{
try{
cdb=db.getconnection();

 if(cdb==null)
	 return false;
 else
 	{	mystmnt= cdb.createStatement();
 		String s="'"+question+"','"+A+"',"+"','"+B+"',"+"','"+C+"',"+"','"+D+"',"+"','"+answer+"',"+g_id+","+5000+qnum;
 		qnum++;
 		int myres=mystmnt.executeUpdate("insert into multiquestion (Question,A,B,C,D,Answer,G_ID,Q_ID) value"+s+")");
 		if(myres==-1)
 			return false;
 		else return true;
 	}
 } 
catch (Exception ex) {
return false;
}

}
public ArrayList<String> get_Multiple_question(int g_id)
{
try {
cdb=db.getconnection();
 if(cdb==null)
	 return null;
 else
 {mystmnt= cdb.createStatement();
 
 
 ResultSet myres=mystmnt.executeQuery("select Question,A,B,C,D,Answer from multiquestion where G_ID="+g_id);
 if (myres==null)
	 return null ;
 else {

	 while (myres.next())
	 	{
		 multiple_question.add(myres.getString("Question"));
		 multiple_question.add(myres.getString("A"));
		 multiple_question.add(myres.getString("B"));
		 multiple_question.add(myres.getString("C"));
		 multiple_question.add(myres.getString("D"));
		 multiple_question.add(myres.getString("Answer"));

	 	}
	 }
		 }

return multiple_question;

} catch (Exception e) {
return null;
}


}

public boolean CopyGame(int id)
	{
		try {
			cdb=db.getconnection();
			 if(cdb==null)
				 return false;
			 else
			 {mystmnt= cdb.createStatement();
			 
			 
			 ResultSet myres=mystmnt.executeQuery("Select * from game where G_ID=3"+id);
			 if (myres==null)
				 return false ;
			 else {

				 mystmnt= cdb.createStatement();
 		 		String s="'"+myres.getString("g_name")+"',"+myres.getInt("course")+",'"+myres.getString("category")+"',"+myres.getInt("T_ID")+","+myres.getInt("G_ID")+",'"+myres.getString("description") +"'";
 		 		
 		 		int myres2=mystmnt.executeUpdate("insert into game (g_name,course,category,T_ID,G_ID,description) value ("+s+")");
 		 		return true;
			 }
			 } 

			
		} catch (Exception e) {
			return false;
		}
	}
}
