package WorkOuts23_11_21_Constructor_StaticFinal;

public class Non_Tech extends Tech_P {
String sub1;
	
	Non_Tech(String name,String gender,String city,String email,int phone,
			int empid,int exp,String desig,String dept,double sal,String sub1)
	{
		
		super(name, gender, city, email,phone, 103,2, "nontech","bsc",45456);
		this.sub1=sub1;
	}
	public void disNT()
	{
		System.out.println("Subject 1  :"+sub1);
		System.out.println("********************");

	}

}
