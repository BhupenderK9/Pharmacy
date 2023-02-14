package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import bean.Diagnostic;
import bean.Medicine;
import utility.DbConnection;

public class Dao3 {

	public List<Diagnostic> getDiagList(int id) {
		// TODO Auto-generated method stub
		Connection con=DbConnection.getConnection();
		String diagnostic_name = null;
		int price=1,quant,totalprice;
		List<Diagnostic> dl=new ArrayList<Diagnostic>();
		try {
			PreparedStatement stmt=con.prepareStatement("select * from diagnostic_issued where patient_id=?");
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			   while(rs.next())
			    {
				int diagnostic_id=rs.getInt("diagnostic_id");
				PreparedStatement st2=con.prepareStatement("select * from diaognistic_details where test_id=?");
				st2.setInt(1, diagnostic_id);
				ResultSet rs2=st2.executeQuery();
				          if(rs2.next())
				             {
					 diagnostic_name=rs2.getString("test_name");
				       price=rs2.getInt("charge");
				             }
				         
				          Diagnostic d=new Diagnostic();
				          d.setTestName(diagnostic_name);
				          d.setCharge(price);
				          d.noftimes=rs.getInt("no_of_times");
				          
				          dl.add(d);
				          
			    }
			   return dl;
			
		    } //end of try block
		  catch (SQLException e)
		    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
		
		return null;
	}

	public List<Diagnostic> getDiagnostic() {
		// TODO Auto-generated method stub
		Connection con=DbConnection.getConnection();
		List<Diagnostic> da=new ArrayList<Diagnostic>();
		try {
			PreparedStatement stmt=con.prepareStatement("select * from  diaognistic_details");
			ResultSet rs=stmt.executeQuery();
             	 while(rs.next())
			    {
				    Diagnostic d=new Diagnostic();
				    d.setTestid(rs.getInt("test_id"));
				    d.setTestName(rs.getString("test_name"));
				    d.setCharge(rs.getInt("charge"));
				    da.add(d);
				    
             		 
			    }
			
             	 return da;
		    } //end of try block
		        catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public String addTest(String[] ids,int pid) {
		// TODO Auto-generated method stub
		
		Connection con=DbConnection.getConnection();
		
		try {
			  for(int i=0;i<ids.length;i++)
			     {
				  int id=Integer.parseInt(ids[i]);
			     PreparedStatement stmt=con.prepareStatement("select * from  diagnostic_issued where patient_id=? && "
			     		+ "diagnostic_id=?");
			     stmt.setInt(1, pid);stmt.setInt(2, id);
			     ResultSet rs=stmt.executeQuery();
			            if(rs.next())
			            {
                             int not=rs.getInt("no_of_times");
                             not=not+1;
                             PreparedStatement st2=con.prepareStatement("update diagnostic_issued set no_of_times=? where "
                             		+ "patient_id=? && diagnostic_id=? ");
                             st2.setInt(1, not);st2.setInt(2,pid);st2.setInt(3, id);
                             if(st2.executeUpdate()>0)
 			            	{
 			            		return "suceesfully update";
 			            	}
 			            	else
 			            	{
 			            		return "something went wrong";
 			            	}
			            }
			            
			            else
			            {
			            	PreparedStatement st3=con.prepareStatement("insert into diagnostic_issued (patient_id,diagnostic_id,no_of"
			            			+ "_times) values(?,?,?)");
			            	st3.setInt(1, pid);st3.setInt(2,id);st3.setInt(3, 1);
			            	if(st3.executeUpdate()>0)
			            	{
			            		return "suceesfully update";
			            	}
			            	else
			            	{
			            		return "something went wrong";
			            	}
			            }
			     }
			
		    } //end of try block
		    catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
