package model;

import java.util.List;

import database.DBService;
import database.DBException;

public class MessageManager {

	public List<Message> getMessages(){
		List<Message> result=null;
		try {
			result =DBService.getDBMessage().getMessageList();
		} 
		catch (DBException e) {
			return null;
		}
		return result;
	}
	
	public boolean addMessage(Message message){
		try{
			DBService.getDBMessage().addMessage(message);
			return true;
		}
		catch (DBException e){
			return false;
		}
	}
	public static Message createMessage(String author, String content){
		return new Message(author,content);
	}
}
