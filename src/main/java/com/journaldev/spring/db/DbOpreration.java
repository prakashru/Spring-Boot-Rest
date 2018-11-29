package com.journaldev.spring.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbOpreration {
	
	public static void main(String[] args)
	  {
	    try
	    {
	      // create our mysql database connection
	      String myDriver = "org.gjt.mm.mysql.Driver";
	      String myUrl = "jdbc:mysql://148.66.136.123/study_new";
	      
	      /*connect = DriverManager
                  .getConnection("jdbc:mysql://localhost/feedback?"
                          + "user=sqluser&password=sqluserpw");*/
	      
	      
	      Class.forName(myDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "study_db_user", "studydb!@#123");
	      
	      // our SQL SELECT query. 
	      // if you only need a few columns, specify them by name instead of using "*"
	      String query = "SELECT * FROM login_tb";

	      // create the java statement
	      Statement st = conn.createStatement();
	      
	      // execute the query, and get a java resultset
	      ResultSet rs = st.executeQuery(query);
	      
	      while(rs.next()) {
	    	  
	    	  	String user_id =  rs.getString("LOGIN_ID");
	    	  	String password = rs.getString("PASSWORD");
	    	  	System.out.println("user id :"+user_id+ " pass :"+ password);
	    	  
	      }
	      
	      // iterate through the java resultset
	      /* while (rs.next())
	      {
	        int id = rs.getInt("id");
	        String firstName = rs.getString("first_name");
	        String lastName = rs.getString("last_name");
	        Date dateCreated = rs.getDate("date_created");
	        boolean isAdmin = rs.getBoolean("is_admin");
	        int numPoints = rs.getInt("num_points");
	        
	        // print the results
	        System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
	      } */
	      st.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
	  }
	}


