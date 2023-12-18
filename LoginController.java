package jdbc_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		PersonCRUD crud=new PersonCRUD();
		try {
		 	String dbPassword=crud.getPerson(email);
		 	PrintWriter out=resp.getWriter();
		 	if(dbPassword!=null)
		 	{
		 	if(dbPassword.equals(password))
		 	{
		 	  RequestDispatcher dispatcher=req.getRequestDispatcher("success.html");
              dispatcher.forward(req, resp);		 	  
		 	}
		 	else
		 	{
		 		out.print("login fail");
		 	}
		 	}
		 	else
		 	{
		 		out.print("user not found,please register");
		 	}
		 	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
