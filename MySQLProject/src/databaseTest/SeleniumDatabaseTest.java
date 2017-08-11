package databaseTest;

import java.sql.*;

public class SeleniumDatabaseTest {
	
	public static void main(String[] args) {
		
		// add comment
		Connection conn = null;
		
		String url = "jdbc:mysql://localhost:3306/";
		String databaseName = "sakila";
		String username = "root";
		String password = "qazxswe";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url+databaseName, username, password);
			
			String sqlQuerry = "Select * from film order by film_id desc";
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sqlQuerry);
			
			result.next();
			System.out.println(result.getString("film_id"));
			System.out.println(result.getString("title"));
			System.out.println(result.getString("description"));
			System.out.println(result.getString("release_year"));
			System.out.println(result.getString("length"));
		}
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			if (conn != null){
				conn = null;
			}
		}
	}
		
} 


