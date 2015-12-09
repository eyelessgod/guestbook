package model;

import java.util.List;

import database.BasicDB;
import database.DBException;

public class MessageManager {
	public List<Message> getMessages(){
		List<Message> result=null;
		try {
			result =BasicDB.getDBMessage().getMessageList();
		} 
		catch (DBException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean addMessage(Message message){
		try{
			BasicDB.getDBMessage().addMessage(message);
			return true;
		}
		catch (DBException e){
			e.printStackTrace();
			return false;
		}
	}
	public static Message createMessage(String author, String content){
		return new Message(author,content);
	}
}
