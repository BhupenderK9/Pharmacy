<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bean.Patient"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
if( session.getAttribute("username")==null)
{
response.sendRedirect("index.html");
}
else
{
	Patient p=(Patient)session.getAttribute("patient");
	
%>


               <h1>customer details for edit</h1>
	   
	   <form action="ExeOp">
	     <label>ID:</label><input type="text"  value=<%= p.id %> name="id"  >
	   <label>SSNID:</label><input type="text"  value=<%= p.ssnid %> name="ssnid"  >
	   <label>NAME:</label><input type="text"  value="<%= p.name %>" name="name">
	   <label>AGE:</label><input type="text"  value="<%= p.age %>" name="age">
	   <label>adress:</label><input type="text"  value="<%= p.adress%>" name="adress">
	   <label>stat:e</label><input type="text"  value="<%= p.state %>" name="state">
	   <label>city:</label><input type="text"  value="<%= p.city %>" name="city">
	   
	   <input type="hidden" name="source" value="editdetails">
	   
	   <input type="submit" value="Update">
	   
	   
	   
	   </form>



<%	
	
}	
%>



</body>
</html>