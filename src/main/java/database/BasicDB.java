package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BasicDB {
	
	private static final String driverName="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/guestbook";
	private static final String user="root";
	private static final String password="Mysql12993.";
	
	public static Connection getDBConnection() throws DBException{
		
		try {
			Class.forName(driverName);
		}
		catch (ClassNotFoundException e) {
			throw new DBException(e);
		}
		
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException(e);
		}
	}
	public static DBMessage getDBMessage(){
		return new DBMessage();
	}
	public static DBUser getDBUser(){
		return new DBUser();
	}
}
