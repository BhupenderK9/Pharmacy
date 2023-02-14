package bean;

public class Diagnostic {

	public int test_id,charge,noftimes;
	public String test_name;
	
	public void setTestid(int id)
	{
		this.test_id=id;
	}
	
	public void setCharge(int ch)
	{
		this.charge=ch;
	}
	
	public void setTestName(String nm)
	{
		this.test_name=nm;
	}
	
	public int getTestid()
	{
		return this.test_id;
	}
	
	public String getTestName()
	{
		return this.test_name;
	}
	
	public int getTestCharge()
	{
		return this.charge;
	}
	
}
