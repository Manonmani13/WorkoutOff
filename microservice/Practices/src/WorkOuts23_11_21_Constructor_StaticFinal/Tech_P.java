package WorkOuts23_11_21_Constructor_StaticFinal;

public class Tech_P extends Person{
	int empid;
	int exp;
	String desig;
	String dept;
	double sal;
	Tech_P(String name,String gender,String email,String city,int phone,int empid,int exp,
			String desig,String dept,double sal)
	{
		super(name,gender,email,city,phone);
		this.empid=empid;
		this.exp=exp;
		this.desig=desig;
		this.dept=dept;
		this.sal=sal;
	}
	public void disTP()
	{
		System.out.println("Emp id     :"+empid);
		System.out.println("Experience :"+exp);
		System.out.println("Desig      :"+desig);
		System.out.println("Dept       :"+dept);
		System.out.println("sal        :"+sal);
	}

}
