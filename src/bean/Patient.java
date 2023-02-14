package bean;

import java.util.Date;

public class Patient {
	
	public Patient(int ssnid, String name, int age, String adress, String state, String city,String tob) {
		// TODO Auto-generated constructor stub
		this.ssnid=ssnid;
		this.name=name;
		this.age=age;
		this.adress=adress;
		this.state=state;
		this.city=city;
		this.tob=tob;
	}
	public Patient() {
		// TODO Auto-generated constructor stub
	}
	public int ssnid,id,age;
	public Date date;
	public String name,adress,state,city,tob;

}
