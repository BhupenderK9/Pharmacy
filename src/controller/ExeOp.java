package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Patient;
import service.Service;

/**
 * Servlet implementation class ExeOp
 */
@WebServlet("/ExeOp")
public class ExeOp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExeOp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		Patient p=new Patient();
		String s1=request.getParameter("source");
		if(s1.equals("createpatient"))
		{
		//boolean b=Service.checkPatient(p);
		     int ssnid=Integer.parseInt(request.getParameter("ssnid"));
		     String name=request.getParameter("name");
		     int age=Integer.parseInt(request.getParameter("age"));
		     String adress=request.getParameter("adress");
		     String state=request.getParameter("state");
		     String city=request.getParameter("city");
		     String tob=request.getParameter("tob");
		     Patient p1=new Patient(ssnid,name,age,adress,state,city,tob);
		     boolean f=Service.createPatient(p1);
		         if(f)
		             {
		    	 out.println("patient details inserted succesffully");
		              }
		         else
		             {
		        	 out.print("something went wrong");
		             }		     
		
		}
		
		else if(s1.equals("checkforupdate"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			boolean b=Service.checkPatient(id);
			if(b)
			{
				Patient p2=Service.getPatient(id);
				HttpSession ses=request.getSession();
				ses.setAttribute("patient", p2);
				response.sendRedirect("UpdatePatientDisplay.jsp");
				
			}
			else
			{
				out.println("patient with id " + id + "doesnot exists");
			}
			
			
		}
		
		else if(s1.equals("editdetails"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
		     String name=request.getParameter("name");
		     int age=Integer.parseInt(request.getParameter("age"));
		     String adress=request.getParameter("adress");
		     String state=request.getParameter("state");
		     String city=request.getParameter("city");
		     //String tob=request.getParameter("tob");
		     Patient p3=new Patient();
		     p3.id=id;p3.name=name;p3.age=age;p3.adress=adress;p3.state=state;p3.city=city;
		     boolean b=Service.updatePatient(p3);
		     if(b)
		     {
		    	out.println("updation success"); 
		     }
		     else
		     {
		    	out.println("something went wrong"); 
		     }
		}
		
		else if(s1.equals("checkfordelete"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			boolean b=Service.checkPatient(id);
			if(b)
			{
				Patient p2=Service.getPatient(id);
				HttpSession ses=request.getSession();
				ses.setAttribute("patient", p2);
				response.sendRedirect("DeletePatientDisplay.jsp");
				
			}
			else
			{
				out.println("patient with id " + id + "doesnot exists");
			}
			
			
		}
		
		
		else if(s1.equals("deletedetails"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
		     String name=request.getParameter("name");
		     int age=Integer.parseInt(request.getParameter("age"));
		     String adress=request.getParameter("adress");
		     String state=request.getParameter("state");
		     String city=request.getParameter("city");
		     //String tob=request.getParameter("tob");
		     Patient p3=new Patient();
		     p3.id=id;p3.name=name;p3.age=age;p3.adress=adress;p3.state=state;p3.city=city;
		     boolean b=Service.deletePatient(p3);
		     if(b)
		     {
		    	out.println("deletion success"); 
		     }
		     else
		     {
		    	out.println("something went wrong"); 
		     }
		}
		
	}// end of get method

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
