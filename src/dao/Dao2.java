package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Medicine;
import bean.Patient;
import utility.DbConnection;

public class Dao2 {
	
	public int quantchange;

	public List<Medicine> getMedList(int id) {
		// TODO Auto-generated method stub
Connection con=DbConnection.getConnection();
       List<Medicine> ml=new ArrayList<Medicine>();
		
		try {
			
			PreparedStatement stmt=con.prepareStatement("select * from issued_med where patient_id=?");
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			    while(rs.next())
			        {
			    	Medicine m=new Medicine();
			    	m.med_id=rs.getInt("med_id");
			    	m.med_quant=rs.getInt("quantity");
			    	
			    	PreparedStatement st2=con.prepareStatement("select * from medicine_details where med_id=?");
			    	st2.setInt(1, m.med_id);
			    	ResultSet rs2=st2.executeQuery();
			    	   while(rs2.next())
			    	       {
			    		      if(rs2.getInt(1)==m.med_id)
			    		        {
			    			   m.med_price=rs2.getInt("price");
			    			   m.med_name=rs2.getString("med_name");
			    		        }
			    		
			    	       }
			    	   ml.add(m);
			    	
			    	
			    	
			    		
			    		
			    	
			    	
				
			        } 
			
		    
		    } //end of try block
		 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ml;
	}

	public List<Medicine> getMedicineData() {
		// TODO Auto-generated method stub
		Connection con=DbConnection.getConnection();
	       List<Medicine> md=new ArrayList<Medicine>();
			
			try {
				
				PreparedStatement stmt=con.prepareStatement("select * from medicine_details");
				
				ResultSet rs=stmt.executeQuery();
				    while(rs.next())
				        {
				    	Medicine m=new Medicine();
				    	m.med_id=rs.getInt("med_id");
				    	m.med_quant=rs.getInt("quantity_available");
				    	m.med_name=rs.getString("med_name");
				    	m.med_price=rs.getInt("price");
				    	
				    	   md.add(m);
				    					    					    					    									    	
				    	
					
				        } 
				
			    
			    } //end of try block
			 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return md;
	}

	public String changeIssue(int id, int med_id, int quant) {
		// TODO Auto-generated method stub
		
		Connection con=DbConnection.getConnection();
		try {
			PreparedStatement stmt=con.prepareStatement("select * from medicine_details where med_id=?");
			stmt.setInt(1, med_id);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				  if(rs.getInt("med_id")==med_id)
				   {
					  int quantoriginal=rs.getInt("quantity_available");
					       if(quant<=quantoriginal)
					           {
					    	   quantchange=quantoriginal-quant;
					     PreparedStatement st2=con.prepareStatement("update medicine_details set quantity_available=? where "
					     		+ "med_id=?");
					     st2.setInt(1,quantchange);
					     st2.setInt(2, med_id);
					              if(st2.executeUpdate()>0)
					               {
					            	String s2=changePatientMed_details(id,med_id,quant,con);
					            	return s2;
					               }
					              else
					              {
					            	  return "cant update quantity,some thing went wrong";
					              }
					              
					            }
					       
					       else
					         {
					    	   return "quantity entered is more than available";
					         }
				   }  
			}//end of while
			
			
	      }//end of try block
		    catch (SQLException e)
		     {
			// TODO Auto-generated catch block
			e.printStackTrace();
		     }
		
		
		
		return null;
	}

	private String changePatientMed_details(int id, int med_id, int quant, Connection con) throws SQLException {
		// TODO Auto-generated method stub
		int iq=0;
		PreparedStatement st3=con.prepareStatement("select * from issued_med where patient_id=? && med_id=?");
		st3.setInt(1, id);
		st3.setInt(2, med_id);
		ResultSet rs3=st3.executeQuery();
		   if(rs3.next())
		     {
			   iq=rs3.getInt("quantity");
		     iq=iq+quant;
		     PreparedStatement st4=con.prepareStatement("update issued_med set quantity=? where  patient_id=? && med_id=?");
		     st4.setInt(1, iq);
		     st4.setInt(2, id);
		     st4.setInt(3, med_id);
		       if(st4.executeUpdate()>0)
		        {
		    	 return "sucessfully issued medicine";
		        }
		     }
		   else
		     {
			   iq=iq+quant;
			PreparedStatement st5=con.prepareStatement("insert into issued_med (patient_id,med_id,quantity) values(?,?,?)");
			st5.setInt(1, id);
			st5.setInt(2, med_id);
			st5.setInt(3, iq);
			 if(st5.executeUpdate()>0)
		        {
		    	 return "sucessfully issued medicine";
		        }
		     }
		
		return null;
	}

}
