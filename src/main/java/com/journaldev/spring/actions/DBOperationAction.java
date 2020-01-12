package com.journaldev.spring.actions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.journaldev.spring.Person;
import com.journaldev.spring.bean.Users;

public class DBOperationAction {

	public static Users getAllUsers() {
		Users users = new Users();
		try {
			// create our mysql database connection
			String myDriver = "org.gjt.mm.mysql.Driver";
			String myUrl = "jdbc:mysql://148.66.136.123/study_new";

			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "study_db_user", "studydb!@#123");

			// our SQL SELECT query.
			// if you only need a few columns, specify them by name instead of using "*"
			String query = "SELECT * FROM login_tb";

			// create the java statement
			Statement st = conn.createStatement();

			// execute the query, and get a java resultset
			ResultSet rs = st.executeQuery(query);
			List<Person> allPersons= new ArrayList<Person>();
			while (rs.next()) {

				Person person = new Person();

				String user_id = rs.getString("LOGIN_ID");
				String password = rs.getString("PASSWORD");
				System.out.println("user id :" + user_id + " pass :" + password);

				person.setName(user_id);
				person.setPassword(password.toCharArray());
				allPersons.add(person);

			}
			users.setPersons(allPersons);

		
			st.close();

		} catch (Exception e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		}

		return users;
	}

}
