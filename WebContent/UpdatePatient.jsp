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
  <h1>update patient details</h1><br><br>
  <form action="ExeOp">
  <label>enter patient id:</label><br><br>
  <input type="text" name="id"><br><br>
  <input type="hidden" value="checkforupdate" name="source">
  <input type="submit" value="submit">
  </form>
  </center>
	
<%	
	
}
%>

</body>
</html>