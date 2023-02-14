<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bean.Diagnostic"%>
    <%@ page import="java.util.*"%>
    <%@ page import="bean.Patient"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table {
  border-collapse: collapse;
}

table, td, th {
  border: 1px solid black;
}
</style>
</head>
<body>
<%
if( session.getAttribute("username")==null)
{
response.sendRedirect("index.html");
}
else
{
	
	List<Diagnostic> dl=(ArrayList<Diagnostic>)session.getAttribute("issued_diag");
	Patient p=(Patient)session.getAttribute("patient_det");
	
%>
<a href="LogOut">logout</a>
<center>

       <h1>PATIENT DETAILS</h1><br><br>
       
       <table>
       
       <tr>
       
       <th>patient id</th>
       <th>name</th>
       <th>age</th>
       <th>adress</th>
       <th>Date of joining</th>
       <th>type of room</th>
       
       </tr>
       
       <tr>
       
       <td><%= p.id %></td>
       <td><%= p.name %></td>
       <td><%= p.age %></td>
       <td><%= p.adress %></td>
       <td><%= p.date %></td>
       <td><%= p.tob %></td>
       
       
       </tr>
       
       </table>
       
    
    <h1>ISSUED Tests</h1>  
    
       <table>
	
	     <tr>
	     
	     <th>test_name</th>
	     <th>quantity</th>
	     <th>rate</th>
	     <th>amount</th>
	     
	       
	     </tr>
	     
	     <%
	     for(int i=0;i<dl.size(); i++)
	     {
	    	 %>
	    	 
	    	 <tr>
	    	 
	    	 <td><%= dl.get(i).test_name %></td>
	    	 <td><%= dl.get(i).noftimes %></td>
	    	 <td><%= dl.get(i).charge %></td>
	    	 <td><% int amount=dl.get(i).charge * dl.get(i).noftimes;%>
	    	 <%= amount %>
	    	 </td>
	    	 
	    	 
	    	 
	    	 </tr>
	    	 
	    	 
	    	 <% 
	     }
	     %>
	
	
	
	
	
	</table><br><br>
       
       
       <form action="DiagOp">
       
       <input type="hidden" value="issuetest" name="source">
       <input type="hidden" name="id" value="<%= p.id %>">
       <input type="submit" value="issue test">
       
       </form>

</center>
      

<%	
	
}
%>




</body>
</html>