<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function handleSelect(elm)
{
	 document.getElementById('myIframe').src = elm.value;
}
</script>
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
<center></center>
<h1>welcome  <%= session.getAttribute("username") %></h1>
</center>
<a href="LogOut" style="float:right;">logout</a>

<center>

<select name="formal" onchange="javascript:handleSelect(this)" style="background-color:blue;">
<option value="patient">patient</option>
<option value="CreatePatient.jsp">create patient</option>
<option value="UpdatePatient.jsp">Update Patient</option>
<option value="DeletePatient.jsp">Delete Patient</option>
<option value="ViewPatients">view Patient</option>
</select>
 <br><br>
 
 
<iframe src="index.html" name="iframe_a" id="myIframe" style="width:100%;height:500px;"></iframe>
      
    
      


</center>

<%
}
%>
</body>
</html>