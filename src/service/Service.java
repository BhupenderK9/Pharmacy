package service;

import java.util.List;

import bean.Diagnostic;
import bean.LoginUser;
import bean.Medicine;
import bean.Patient;
import bean.Role;
import dao.Dao1;
import dao.Dao2;
import dao.Dao3;

public class Service {
	
	
	
	public static Role CheckUser(LoginUser lu)
	{
		Dao1 d1=new Dao1();
		
		Role f=Dao1.checkUser(lu);
		System.out.print(f.role);
		
		return f;
	}

	public static boolean checkPatient(int p) {
		// TODO Auto-generated method stub
		
		Dao1 d1=new Dao1();
		
		boolean f=d1.checkPatient(p);
		
		return f;
	}

	public static boolean createPatient(Patient p1) {
		// TODO Auto-generated method stub
		Dao1 d1=new Dao1();
		boolean f=d1.createPatient(p1);
		
		return f;
	}

	public static Patient getPatient(int id) {
		// TODO Auto-generated method stub
		Dao1 d1=new Dao1();
		Patient p=d1.getPatient(id);
		
		
		return p;
	}

	public static boolean updatePatient(Patient p3) {
		// TODO Auto-generated method stub
		
		Dao1 d1=new Dao1();
		boolean f=d1.updatePatient(p3);
		
		
		return f;
	}

	public static boolean deletePatient(Patient p3) {
		// TODO Auto-generated method stub
		Dao1 d1=new Dao1();
		boolean f=d1.deletePatient(p3);
		
		
		return f;
	}

	public static List<Patient> getPatientDetails() {
		// TODO Auto-generated method stub
		Dao1 d1=new Dao1();
		List<Patient> f=d1.getPatientDetails();
		
		
		return f;
	
	}

	public static List<Medicine> getMedList(int id) {
		// TODO Auto-generated method stub
		Dao2 d2=new Dao2();
		List<Medicine> ml=d2.getMedList(id);
		
		return ml;
	}

	public static List<Medicine> getMedicineData() {
		// TODO Auto-generated method stub
		Dao2 d2=new Dao2();
		List<Medicine> md=d2.getMedicineData();
		return md;
	}

	public static String changeIssue(int id, int med_id, int quant) {
		// TODO Auto-generated method stub
		Dao2 d2=new Dao2();
		String b=d2.changeIssue(id,med_id,quant);
		return b;
	}

	public static List<Diagnostic> getDiagList(int id) {
		// TODO Auto-generated method stub
		Dao3 d2=new Dao3();
		List<Diagnostic> dl=d2.getDiagList(id);
		
		return dl;
		
	}

	public static List<Diagnostic> getDiagnostic() {
		// TODO Auto-generated method stub
		Dao3 d2=new Dao3();
		List<Diagnostic> dl=d2.getDiagnostic();
		
		return dl;
	}

	public static String addTest(String[] ids, int id) {
		// TODO Auto-generated method stub
		Dao3 d3=new Dao3();
		String s=d3.addTest(ids,id);
		
		return s;
	}
	

}
