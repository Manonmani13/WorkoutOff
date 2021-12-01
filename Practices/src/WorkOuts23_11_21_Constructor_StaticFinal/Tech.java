package WorkOuts23_11_21_Constructor_StaticFinal;

public class Tech extends Tech_P{
	String sub1;
	String sub2;
	String sub3;
	Tech(String name,String gender,String email,String city,int phone,
			int empid,int exp,String desig,String dept,double sal,String sub1,String sub2,String sub3)
	{
		super(name,gender,email,city, 123,3, phone, "teacher","bcom",98787);
		this.sub1=sub1;
		this.sub2=sub2;
		this.sub3=sub3;
	}
	public void disT()
	{
		System.out.println("Subject 1  :"+sub1);
		System.out.println("Subject 2  :"+sub2);
		System.out.println("Subject 3  :"+sub3);
		System.out.println("*****************");
		}

}
