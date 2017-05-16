package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.util.ResultSetUtil;

import DB.DB_Connection;

public class Comment {
	 private static Connection cdb=null;
	    Statement mystmnt=null;
	    DB_Connection db=null;
	    String comment="";
	    int ID;
	    static int num=0;
	    int Game_ID;
		public Comment() {
			super();
		}
		public static Connection getCdb() {
			return cdb;
		}
		public static void setCdb(Connection cdb) {
			Comment.cdb = cdb;
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
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
		public int getID() {
			return ID;
		}
		public void setID(int iD) {
			ID = iD;
		}
		public int getGame_ID() {
			return Game_ID;
		}
		public void setGame_ID(int game_ID) {
			Game_ID = game_ID;
		}
		
		public boolean AddStudentComment(String com,int id ,int gid,int tid)
		{
			try {
				cdb=db.getconnection();
				
				 if(cdb==null)
					 return false;
				 else
				 {mystmnt= cdb.createStatement();
				 String s="'"+com+"',"+num+","+gid+","+id;
				 num++;
				 int myres=mystmnt.executeUpdate("insert into g_comment(comm,C_ID,G_ID,S_ID) value("+s+")");
				 if(myres==-1)
					 return false;
				 else{ 
					 Notification n=new Notification();
					 String not="Their is a student that make a comment on Game that their ID ="+gid;
					 n.AddTeacherNotification(not, tid);
					 return true;
					 }
				 }
			} catch (Exception e) {
				return false;
			}
			}
		public boolean AddTeacherComment(String com,int id ,int gid)
		{
			try {
				cdb=db.getconnection();
				
				 if(cdb==null)
					 return false;
				 else
				 {mystmnt= cdb.createStatement();
				 String s="'"+com+"',"+num+","+gid+","+id;
				 num++;
				 int myres=mystmnt.executeUpdate("insert into g_comment(comm,C_ID,G_ID,T_ID) value("+s+")");
				 if(myres==-1)
					 return false;
				 else return true;
				 }
			} catch (Exception e) {
				return false;
			}
			}
		

	    public ArrayList<String>getStudentComment(int gid,int sid)
	    {
	    	ArrayList<String >Comment=new ArrayList<String>();
	    	try {cdb=db.getconnection();
			
			 if(cdb==null)
				 return null;
			 else {
				 mystmnt= cdb.createStatement();
				 ResultSet myres=mystmnt.executeQuery("select comm from g_comment where G_ID="+gid+" and S_ID="+sid);
				 while (myres.next())
				 {
					 Comment.add(myres.getString("comm"));
				 }
				 return Comment;
			 }
			 
			} catch (Exception e) {
				return null;
			}
	    }
	    public ArrayList<String>getTeacherComment(int gid,int sid)
	    {
	    	ArrayList<String >Comment=new ArrayList<String>();
	    	try {cdb=db.getconnection();
			
			 if(cdb==null)
				 return null;
			 else {
				 mystmnt= cdb.createStatement();
				 ResultSet myres=mystmnt.executeQuery("select comm from g_comment where G_ID="+gid+" and T_ID="+sid);
				 while (myres.next())
				 {
					 Comment.add(myres.getString("comm"));
				 }
				 return Comment;
			 }
			 
			} catch (Exception e) {
				return null;
			}
	    }
	    public ArrayList<String>getGameComment(int gid)
	    {
	    	ArrayList<String >Comment=new ArrayList<String>();
	    	try {cdb=db.getconnection();
			
			 if(cdb==null)
				 return null;
			 else {
				 mystmnt= cdb.createStatement();
				 ResultSet myres=mystmnt.executeQuery("select comm from g_comment where G_ID="+gid);
				 while (myres.next())
				 {
					 Comment.add(myres.getString("comm"));
				 }
				 return Comment;
			 }
			 
			} catch (Exception e) {
				return null;
			}
	    }

}
