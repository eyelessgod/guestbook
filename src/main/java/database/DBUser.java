package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

public class DBUser {

public void addUser(User user) throws DBException{
		
		Connection connection=null;
		PreparedStatement statement=null;
		
		try{
			connection=BasicDB.getDBConnection();
			statement=connection.prepareStatement("insert into users(login,password) values(?,?)");
			statement.setString(1, user.getName());
			statement.setString(2, user.getPassword());
			statement.executeUpdate();			
				
		}
		catch(Exception e){
			throw new DBException(e);
		}
		finally{
			try {
				if(statement!=null){
					statement.close();
				}
				if(connection!=null){
					connection.close();
				}
			}
			catch (SQLException e) {
				throw new DBException(e);
			}
			
		}
	}

public User getUser(String login) throws DBException{
	
	Connection connection=null;
	PreparedStatement statement=null;
	
	try{
		connection=BasicDB.getDBConnection();
		statement=connection.prepareStatement("select login,password from users where login=?");
		statement.setString(1, login);
		ResultSet result=statement.executeQuery();
		if (result.next()){
			String password=result.getString(2);
			return new User(login,password);
		}
		else return null;
			
	}
	catch(Exception e){
		throw new DBException(e);
	}
	finally{
		try {
			if(statement!=null){
				statement.close();
			}
			if(connection!=null){
				connection.close();
			}
		}
		catch (SQLException e) {
			throw new DBException(e);
		}
		
	}
}
}
