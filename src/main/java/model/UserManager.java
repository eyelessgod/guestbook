package model;

import database.BasicDB;
import database.DBException;

public class UserManager {
	public static final int UM_SUCCESS=0;
	public static final int UM_INVALID_USERNAME=1;
	public static final int UM_INVALID_PASSWORD=2;
	public static final int UM_DBERROR=3;
	
	public int validate(String login, String password){
		try{
			User user=BasicDB.getDBUser().getUser(login);
			if(user!=null){
				if(user.getPassword().equals(password)){
					return UM_SUCCESS;
				}
				else{
					return UM_INVALID_PASSWORD;
				}
			}
			else{
				return UM_INVALID_USERNAME;
			}
		}
		catch(DBException e){
			return UM_DBERROR;
		}
		
		
	}
	private boolean userIsExist(String login) throws DBException{
		try{
			if(BasicDB.getDBUser().getUser(login)!=null){
				return true;
			}
			else{
				return false;
			}	
		}
		catch(DBException e){
			e.printStackTrace();
			throw new DBException(e);
		}
	}
	
	public int addUser(User user){
		try{
			if(userIsExist(user.getName())){
				return UM_INVALID_USERNAME;
			}
			else{
				BasicDB.getDBUser().addUser(user);
				return UM_SUCCESS;
			}
		}
		catch (DBException e) {
			e.printStackTrace();
			return UM_DBERROR;
		}
		
	}
	public static User createUser(String name,String password){
		return new User(name,password);
	}
}
