package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Message;

public class DBMessage {
	public List<Message>getMessageList() throws DBException{
		
		Connection connection=null;
		Statement statement=null;
		
		try{
			connection=BasicDB.getDBConnection();
			statement=connection.createStatement();
			List<Message> messages=new ArrayList<Message>();
			ResultSet result=statement.executeQuery("select author,content from messages");
						
			while(result.next()){
				String author=result.getString(1);
				String content=result.getString(2);				
				messages.add(new Message(author,content));
			}
			return messages;	
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
	
	public void addMessage(Message message) throws DBException{
		
		Connection connection=null;
		PreparedStatement statement=null;
		
		try{
			connection=BasicDB.getDBConnection();
			statement=connection.prepareStatement("insert into messages(author,content) values(?,?)");
			statement.setString(1, message.getUsername());
			statement.setString(2, message.getContent());
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
}
