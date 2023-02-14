package dao;

import java.sql.*;
import java.util.*;
import java.util.List;

import bean.LoginUser;
import bean.Patient;
import bean.Role;
import utility.DbConnection;

public class Dao1 {

	public static Role checkUser(LoginUser lu)
	{
		
		Connection con=DbConnection.getConnection();
		
		try {
			
			PreparedStatement stmt=con.prepareStatement("select * from userstore");
			ResultSet rs=stmt.executeQuery();
			    while(rs.next())
			        {
			    	
			    	
			    	if(rs.getString(1).equals(lu.getLogin()) && rs.getString(2).equals(lu.getPassword()))
			    	                   {
			    		System.out.println("hlo");
			    		Role r=new Role(rs.getString(4),true);
			    		           return r;
			    		
			    	                   }
				
			        }
			
		    
		    } //end of try block
		 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

	public boolean checkPatient(int p) {
		// TODO Auto-generated method stub
		
Connection con=DbConnection.getConnection();
		
		try {
			
			PreparedStatement stmt=con.prepareStatement("select * from patients");
			ResultSet rs=stmt.executeQuery();
			    while(rs.next())
			        {
			    	
			    	
			    	if(rs.getInt(2)==p )
			    	                   {
			    	
			    		           return true;
			    		
			    	                   }
				
			        }
			
		    
		    } //end of try block
		 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	public boolean createPatient(Patient p1) {
		// TODO Auto-generated method stub
		
		Connection con=DbConnection.getConnection();
		
		try {
			PreparedStatement stmt=con.prepareStatement("insert into patients (ssnid,name,age,adress,state,city,status,tob,doj)"
					+ "values(?,?,?,?,?,?,?,?,?)");
			stmt.setInt(1, p1.ssnid);
			stmt.setString(2, p1.name);
			stmt.setInt(3,p1.age);
			stmt.setString(4,p1.adress);
			stmt.setString(5, p1.state);
			stmt.setString(6, p1.city);
			stmt.setString(7,"active");
			stmt.setString(8, p1.tob);
			java.util.Date date=new java.util.Date();			
			java.sql.Date sqlDate=new java.sql.Date(date.getTime());
			stmt.setDate(9, sqlDate);
			    if(stmt.executeUpdate()>=1)
			               {
			    	return true;
			               }
			    else 
			       {
			    	return false;
			       }
			
		    } //end of try block
		catch (SQLException e) {
		  	// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	public Patient getPatient(int id) {
		// TODO Auto-generated method stub
Connection con=DbConnection.getConnection();
		
		try {
			
			PreparedStatement stmt=con.prepareStatement("select * from patients where id=?");
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			    while(rs.next())
			        {
			    	
			    	if(rs.getInt(2)==id)
			    	{
			    		Patient p=new Patient();
			    		p.ssnid=rs.getInt(1);
			    		p.id=id;
			    		p.name=rs.getString("name");
			    		p.age=rs.getInt("age");
			    		p.state=rs.getString("state");
			    		p.adress=rs.getString("adress");
			    		p.city=rs.getString("city");
			    		p.date=rs.getDate("doj");
			    		p.tob=rs.getString("tob");
			    	return p;
			    		
			    		
			    	}
			    	
				
			        }
			
		    
		    } //end of try block
		 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return null;
	}

	public boolean updatePatient(Patient p3) {
		// TODO Auto-generated method stub
Connection con=DbConnection.getConnection();
		
		try {
			PreparedStatement stmt=con.prepareStatement("update patients set name=?,age=?,adress=?,state=?,city=?"
					+ "where id=?");
			stmt.setString(1, p3.name);
			stmt.setInt(2, p3.age);
			stmt.setString(3,p3.adress);
			stmt.setString(4,p3.state);
			stmt.setString(5, p3.city);
			stmt.setInt(6, p3.id);
			
			    if(stmt.executeUpdate()>=1)
			               {
			    	return true;
			               }
			    else 
			       {
			    	return false;
			       }
			
		    } //end of try block
		catch (SQLException e) {
		  	// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean deletePatient(Patient p3) {
		// TODO Auto-generated method stub
Connection con=DbConnection.getConnection();
		
		try {
			PreparedStatement stmt=con.prepareStatement("delete from patients where id=?");
			
			stmt.setInt(1, p3.id);
			
			    if(stmt.executeUpdate()>=1)
			               {
			    	return true;
			               }
			    else 
			       {
			    	return false;
			       }
			
		    } //end of try block
		catch (SQLException e) {
		  	// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

	public List<Patient> getPatientDetails() {
		// TODO Auto-generated method stub
		List<Patient> ps=new ArrayList<Patient>();
		Connection con=DbConnection.getConnection();
		
		try {
			PreparedStatement stmt=con.prepareStatement("select * from patients where status='active' order by id desc");
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next())
			{
				Patient p=new Patient();
				p.id=rs.getInt("id");
				p.name=rs.getString("name");
				p.age=rs.getInt("age");
				p.adress=rs.getString("adress");
				p.date=rs.getDate("doj");
				p.tob=rs.getString("tob");
				ps.add(p);
			}
			
		    } //end of try block
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return ps;
	}
	
	
}
