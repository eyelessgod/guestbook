package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbTest {
	private final String driverName="com.mysql.jdbc.Driver";
	private final String url="jdbc:mysql://localhost:3306/sakila";
	private final String user="root";
	private final String password="Mysql12993.";
	public void test(){
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			System.out.println("class not found");
			e.printStackTrace();
		}
		Connection connection = null;
		Statement statement = null;
		try {
			connection=DriverManager.getConnection(url, user, password);
			
			statement=connection.createStatement();
			ResultSet resultSet=statement.executeQuery("SELECT * FROM actor WHERE first_name='John'");
			
			while(resultSet.next()){
				System.out.println(resultSet.getString(2));
				
				System.out.println(resultSet.getInt(1));
				
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(statement!=null){
					statement.close();
				}
				if(connection!=null){
					connection.close();
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}
	
}
