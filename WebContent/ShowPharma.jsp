<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bean.Medicine"%>
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
<body style="background-color:blue;">
<%
if( session.getAttribute("username")==null)
{
response.sendRedirect("index.html");
}
else
{
	
	List<Medicine> ml=(ArrayList<Medicine>)session.getAttribute("issued_med");
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
       
    
    <h1>ISSUED MEDICINES</h1>  
    
       <table>
	
	     <tr>
	     
	     <th>medicine</th>
	     <th>quantity</th>
	     <th>rate</th>
	     <th>amount</th>
	     
	       
	     </tr>
	     
	     <%
	     for(int i=0;i<ml.size(); i++)
	     {
	    	 %>
	    	 
	    	 <tr>
	    	 
	    	 <td><%= ml.get(i).med_name %></td>
	    	 <td><%= ml.get(i).med_quant %></td>
	    	 <td><%= ml.get(i).med_price %></td>
	    	 <td><% int amount=ml.get(i).med_price * ml.get(i).med_quant;%>
	    	 <%= amount %>
	    	 </td>
	    	 
	    	 
	    	 
	    	 </tr>
	    	 
	    	 
	    	 <% 
	     }
	     %>
	
	
	
	
	
	</table><br><br>
       
       
       <form action="PharmaOp">
       
       <input type="hidden" value="issuemedicine" name="source">
       <input type="hidden" name="id" value="<%= p.id %>">
       <input type="submit" value="issue medicine">
       
       </form>

</center>
      

<%	
	
}
%>


</body>
</html>