package jdbc_servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class PersonCRUD {
	
	public Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlets","root","root");
		return connection;
		
		
	}
	public int signUp(Person person) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO PERSON VALUES(?,?,?,?,?,?,?,?)");
		preparedStatement.setInt(1,person.getId());
		preparedStatement.setString(2, person.getFirst_name());
		preparedStatement.setString(3,person.getLast_name());
		preparedStatement.setInt(4, person.getAge());
		preparedStatement.setLong(5, person.getPhone());
		preparedStatement.setString(6, person.getAddress());
		preparedStatement.setString(7, person.getEmail());
		preparedStatement.setString(8, person.getPassword());
		
		int count=preparedStatement.executeUpdate();
		
		connection.close();
		return count;
		
		
	}
	public int Update(Person person) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update person set first_name=?,last_name=?,age=?,phone=?,address=?,email=?,password=? where id=?");
		
		preparedStatement.setString(1, person.getFirst_name());
		preparedStatement.setString(2,person.getLast_name());
		preparedStatement.setInt(3, person.getAge());
		preparedStatement.setLong(4, person.getPhone());
		preparedStatement.setString(5, person.getAddress());
		preparedStatement.setString(6, person.getEmail());
		preparedStatement.setString(7, person.getPassword());
		preparedStatement.setInt(8,person.getId());
		
		int count=preparedStatement.executeUpdate();
		
		connection.close();
		return count;
	
	}
	public String getPerson(String email) throws Exception
	{
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("select * from person where email=?");
		
		preparedStatement.setString(1, email);
		ResultSet rs=preparedStatement.executeQuery();
		String password=null;
		while(rs.next())
		{
			 password=rs.getString("password");	
		}
		connection.close();
		return password;	
	
	}

	

}
