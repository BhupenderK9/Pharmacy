<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bean.Diagnostic"%>
    <%@ page import="java.util.*"%>
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
	
	List<Diagnostic> dl=(ArrayList<Diagnostic>)session.getAttribute("diagdetails");
	
%>


    <center>
    
         <h1>DIAGNOSTIC DETAILS </h1>
    <form action="DiagOp">
         <table>
         
         
         <tr>
         <th></th>
         <th>test_id</th>
         <th>test_name</th>
         <th>test_name</th>
         </tr>
         
         <%
         for(int i=0;i<dl.size();i++)
         {
        	 %>
        	<tr>
        	<th><input type="checkbox" name="teststoissue" value="<%= dl.get(i).test_id %>"></th>
        	<th><%= dl.get(i).test_id %></th>
        	<th><%= dl.get(i).test_name %></th>
        	<th><%= dl.get(i).charge %></th>
        	
        	</tr> 
        	<%
         }
         %>
        
         </table>
          <input type="hidden" name="source" value="addtests">
         <input type="submit" value="submit">
      </form>
</center>
<% 	
	
	
	
}
%>

</body>
</html>