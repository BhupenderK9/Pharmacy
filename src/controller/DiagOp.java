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

import bean.Diagnostic;
import bean.Medicine;
import bean.Patient;
import service.Service;

/**
 * Servlet implementation class DiagOp
 */
@WebServlet("/DiagOp")
public class DiagOp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiagOp() {
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
		if(s.equals("diag"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			boolean b=Service.checkPatient(id);
		     	if(b)
			     {
		     		Patient p2=Service.getPatient(id);
		     		List<Medicine> ml=Service.getMedList(id);
		     		List<Diagnostic> dl=Service.getDiagList(id);
		     		HttpSession ses=request.getSession();
		     		ses.setAttribute("id",id);
		     		ses.setAttribute("patient_det",p2);
		     		ses.setAttribute("issued_diag", dl);
		     		response.sendRedirect("ShowDiag.jsp");
		     		
		     		
			     }
		     	else
		     	{
		     		out.println("user with provided id doesnt exists");
		     	}
		}
		else if(s.equals("issuetest"))
		{
			int id=Integer.parseInt(request.getParameter("id"));
			List<Diagnostic> da=Service.getDiagnostic();
			HttpSession ses=request.getSession();
			ses.setAttribute("diagdetails", da);
			response.sendRedirect("IssueDiagDisp.jsp");
		}
		
		else if(s.equals("addtests"))
		{
			String[] ids = request.getParameterValues("teststoissue");
			HttpSession ses=request.getSession();
			int id=(int) ses.getAttribute("id");
			
			String s2=Service.addTest(ids,id);
			out.println(s2);
			out.println("click here to go to issue page" + "<form action='DiagOp'>"
					+ "<input type='hidden' value='diag' name='source'>"
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
