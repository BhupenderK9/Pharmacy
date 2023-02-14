package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.LoginUser;
import bean.Role;
import service.Service;
import utility.CheckPattern;

/**
 * Servlet implementation class CheckUser
 */
@WebServlet("/CheckUser")
public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CheckUser() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		boolean f1=CheckPattern.checkLogin(username);
		boolean f2=CheckPattern.checkPassword(password);
		if(f1 && f2)
		{
			  
			LoginUser lu=new LoginUser();
			lu.setLogin(username);
			lu.setPassword(password);
		    Role r=Service.CheckUser(lu);
		    System.out.print(lu.login + lu.password); 
			if(r.f)
			{
				out.print("login success" + lu.login);
				HttpSession	ses=request.getSession();
				ses.setAttribute("username",username);
				     if(r.role.equals("executive"))
				          {
				            response.sendRedirect("DeskExecutive.jsp");
				          }
				     else if(r.role.equals("pharmacist"))
				        {
				    	 response.sendRedirect("Pharmacist.jsp");
				        }
				     else if(r.role.equals("diagnostic"))
				        {
				    	 response.sendRedirect("Diagnostic.jsp");
				        }
				  
			}
			
			else
			{
				out.println("invalid credentials");
				request.getRequestDispatcher("index.html").include(request, response);
			}
			
			
		}
		
		else
		{
			
			request.getRequestDispatcher("index.html").include(request, response);
			out.println("The user ID can be alphabetic or alphanumeric and should have a minimum of 8"
					+ " characters Password should contain 10 characters including one special character,"
					+ " one upper case, one numeric. " + f1 + f2);
			
			
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
