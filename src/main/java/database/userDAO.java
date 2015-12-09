package database;
class UserDAO{

	String getPasswordByName(String name){

		Connection connection=null;
		PreparedStatement statement=null;
		try{
			connection=getDBConnection();
			statement=connection.getStatement();
			query="select password from user where user.name=?";
			ResultSet resultSet=statement.executeQuery(query);
			while(resultSet.next()){
				String password=resultset.getString(1);
			}
			return password; 
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			if(connection!=null){
				connection.close();
			}
			if(statement!=null){
				statement.close();
			}
		}
	}
}