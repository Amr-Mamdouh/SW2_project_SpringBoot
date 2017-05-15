package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DB.DB_Connection;

public class Notification {
	 private static Connection cdb=null;
	    Statement mystmnt=null;
	    DB_Connection db=null;
	    String notificaion="";
	    int ID;
	    static int num=0;
	    int Game_ID;
		 public Notification() {
		 }
		  
		public static Connection getCdb() {
			return cdb;
		}
		public static void setCdb(Connection cdb) {
			Notification.cdb = cdb;
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
		public String getnotification() {
			return notificaion;
		}
		public void setnotification(String notification) {
			this.notificaion = notification;
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
		
		public boolean AddStudentNotification(String not,int id )
		{
			try {
				cdb=db.getconnection();
				
				 if(cdb==null)
					 return false;
				 else
				 {mystmnt= cdb.createStatement();
				 String s="'"+not+"',"+num+","+id;
				 num++;
				 int myres=mystmnt.executeUpdate("insert into user_notifcation (game_Notifcation,Notifcation_ID,S_ID) value("+s+")");
				 if(myres==-1)
					 return false;
				 else return true;
				 }
			} catch (Exception e) {
				return false;
			}
			}
		public boolean AddTeacherNotification(String not,int id)
		{
			try {
				cdb=db.getconnection();
				
				 if(cdb==null)
					 return false;
				 else
				 {mystmnt= cdb.createStatement();
				 String s="'"+not+"',"+num+","+id;
				 num++;
				 int myres=mystmnt.executeUpdate("insert into user_notifcation (game_Notifcation,Notifcation_ID,T_ID) value("+s+")");				 if(myres==-1)
					 return false;
				 else return true;
				 }
			} catch (Exception e) {
				return false;
			}
			}
		

	    public ArrayList<String>getStudentNotification(int sid)
	    {
	    	ArrayList<String >Comment=new ArrayList<String>();
	    	try {cdb=db.getconnection();
			
			 if(cdb==null)
				 return null;
			 else {
				 mystmnt= cdb.createStatement();
				 ResultSet myres=mystmnt.executeQuery("select game_Notifcation from user_notifcation where S_ID="+sid);
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
	    public ArrayList<String>getTeacherNotification(int sid)
	    {
	    	ArrayList<String >Comment=new ArrayList<String>();
	    	try {cdb=db.getconnection();
			
			 if(cdb==null)
				 return null;
			 else {
				 mystmnt= cdb.createStatement();
				 
				 ResultSet myres=mystmnt.executeQuery("select game_Notifcation from user_notifcation where T_ID="+sid);	
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
