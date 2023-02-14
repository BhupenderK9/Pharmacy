<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
%>


<center>
    
  <H1>PHARMACIST BOARD</H1><br><br>
  
  <form action="PharmaOp">
  
  <label>enter patient id:</label><br><br>
  <input type="text" name="id"><br><br>
  <input type="hidden" name="source" value="medic">
  <input type="submit" value="submit">
  
  
  </form>
  
</center>


<% 	
		
}
%>


</body>
</html>