<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="bean.Medicine"%>
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
	
	List<Medicine> ml=(ArrayList<Medicine>)session.getAttribute("medicine_details");
	
	
%>

       <center>
       
       <h1>AVAILABLE MEDICINES</h1>
       
       <table>
	
	     <tr>
	     
	     <th>medicine-id</th>
	     <th>medicine_name</th>
	     <th>quantity_available</th>
	     <th>price</th>
	    
	     
	       
	     </tr>
	     
	     <%
	     for(int i=0;i<ml.size(); i++)
	     {
	    	 %>
	    	 
	    	 <tr>
	    	 
	    	 <td><%= ml.get(i).med_id %></td>
	    	 <td><%= ml.get(i).med_name %></td>
	    	 <td><%= ml.get(i).med_quant %></td>
	    	 <td><%= ml.get(i).med_price %>
	    	 
	    	 
	    	 
	    	 
	    	 
	    	 </tr>
	    	 
	    	 
	    	 <% 
	     }
	     %>
	
	
	
	
	
	</table>
       
       
       <form action="PharmaOp">
       
       <label>enter medicine id:</label><input type="text" name="med_id"><br><br>
       <label>enter quantity:</label><input type="text" name="quant"><br><br>
       <input type="hidden" name="source" value="changeissue">
       <input type="submit" value="submit">
       
       </form>
       
       </center>


<%	
	
	
	
}	
%>
</body>
</html>