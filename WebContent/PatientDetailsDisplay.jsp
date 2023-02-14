<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="bean.Patient"%>
    <%@ page import="java.util.*"%>
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
	List<Patient> ps=(List<Patient>)session.getAttribute("pd");
	
%>

<h1>Patients List</h1><br>
	<table>
	
	     <tr>
	     
	     <th>ID</th>
	     <th>NAME</th>
	     <th>age</th>
	     <th>adress</th>
	     <th>Date of admission</th>
	     <th>type of bed</th>
	       
	     </tr>
	     
	     <%
	     for(int i=0;i<ps.size(); i++)
	     {
	    	 %>
	    	 
	    	 <tr>
	    	 
	    	 <td><%= ps.get(i).id %></td>
	    	 <td><%= ps.get(i).name %></td>
	    	 <td><%= ps.get(i).age %></td>
	    	 <td><%= ps.get(i).adress%></td>
	    	 
	    	 <td><% 
	    	 String s=ps.get(i).date + "" ;
	    	 %><%= s %></td>
	    	 <td><%= ps.get(i).tob %></td>
	    	 
	    	 </tr>
	    	 
	    	 
	    	 <% 
	     }
	     %>
	
	
	
	
	
	</table>
	


<%	
	
	
	
}
%>
</body>
</html>