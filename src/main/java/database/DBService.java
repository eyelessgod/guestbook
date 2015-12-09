package database;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBService {
	
	private static final String DATA_SOURCE_PATH="java:/guestbook";
	private static DataSource ds;
	
	public static Connection getDBConnection() throws DBException{
		
		try {
			Context context = new InitialContext();
			ds=(DataSource) context.lookup(DATA_SOURCE_PATH);
			return ds.getConnection();
		} 
		catch (NamingException e) {
			throw new DBException(e);
		}
		catch (SQLException e){
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
