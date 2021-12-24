package WorkOuts23_11_21;

public class Tech_P extends Person {
	int empid;
	int exp;
	String desig;
	String dept;
	double sal;
	public void detailtp(int empid,int exp,
			String desig,String dept,double sal)
	{
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
