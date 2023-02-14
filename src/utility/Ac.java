package utility;

public class Ac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.Date date=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		System.out.print(sqlDate);
		
	}

}
