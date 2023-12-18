package jdbc_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class UpdateClass extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("id"));
		String first_name=req.getParameter("first_name");
		String last_name=req.getParameter("last_name");
		int age=Integer.parseInt(req.getParameter("age"));
		long phone=Long.parseLong(req.getParameter("phone"));
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Person person=new Person();
		person.setId(id);
		person.setFirst_name(first_name);
		person.setLast_name(last_name);
		person.setAge(age);
		person.setAddress(address);
		person.setPhone(phone);
		person.setEmail(email);
		person.setPassword(password);
		
		PersonCRUD crud=new PersonCRUD();
		try 
		{
			int count=crud.Update(person);
			if(count!=0)
			{
//				PrintWriter out=res.getWriter();
//				out.print("Update Successfully");
				 RequestDispatcher dispatcher=req.getRequestDispatcher("update.html");
	              dispatcher.forward(req, res);	
				
			}
			else
			{
				PrintWriter out=res.getWriter();
				out.print(" not Update Successfully");
			
			}
			
		} 
		catch (Exception e)
		{
	
			e.printStackTrace();
		}
		

		
	}
	

}
