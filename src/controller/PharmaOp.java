package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Medicine;
import bean.Patient;
import service.Service;

/**
 * Servlet implementation class PharmaOp
 */
@WebServlet("/PharmaOp")
public class PharmaOp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PharmaOp() {
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
		String s=request.getParameter("source");
		if(s.equals("medic"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			boolean b=Service.checkPatient(id);
		     	if(b)
			     {
		     		Patient p2=Service.getPatient(id);
		     		List<Medicine> ml=Service.getMedList(id);
		     		HttpSession ses=request.getSession();
		     		ses.setAttribute("id",id);
		     		ses.setAttribute("patient_det",p2);
		     		ses.setAttribute("issued_med", ml);
		     		response.sendRedirect("ShowPharma.jsp");
		     		
		     		
			     }
		     	else
		     	{
		     		out.println("user with provided id doesnt exists");
		     	}
			  
		}
		
		else if(s.equals("issuemedicine"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			List<Medicine> md=Service.getMedicineData();
			HttpSession ses=request.getSession();
     		ses.setAttribute("medicine_details",md);
     		response.sendRedirect("MedicineIssue.jsp");
		}
		
		else if(s.equals("changeissue"))
		{
			HttpSession ses=request.getSession();
			int id=(int) ses.getAttribute("id");
			int med_id=Integer.parseInt(request.getParameter("med_id"));
			int quant=Integer.parseInt(request.getParameter("quant"));
			String f=Service.changeIssue(id,med_id,quant);
			out.println(f);
			out.println("click here to go to issue page" + "<form action='PharmaOp'>"
					+ "<input type='hidden' value='medic' name='source'>"
					+ "<input type='hidden' name='id' value='"+id+"'><input type='submit' value='submit'></form>");
			
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
