<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:blue;">
<%
if( session.getAttribute("username")==null)
{
response.sendRedirect("index.html");
}
else
{
	
	%>
	
	<center>
	
	<h1>ENTER PATIENT DETAILS</h1>
	<form action="ExeOp">
	<label>patient SSNID:</label><input type="text" name="ssnid"><br><br>
	<label>patient name:</label><input type="text" name="name"><br><br>
	<label>patient age:</label><input type="text" name="age"><br><br>
	<label>select type of bed:</label>
	<select  name="tob">
    <option value="gw">general ward</option>
    <option value="sm">semi sharing</option>
     <option value="sr">single room</option>
</select>
	<label>patient address:</label><input type="text" name="adress"><br><br>
	<label>patient city:</label><input type="text" name="city"><br><br>
	<label>patient state:</label><input type="text" name="state"><br><br>
	<input type="hidden" value="createpatient" name="source">
	<input type="submit" value="submit">
	</form>
	
	
	</center>
	
<%	
	
	
	
	
}




%>

</body>
</html>