package WorkOuts23_11_21_Constructor_StaticFinal;

public class Student extends Person {
	int roll;
	int mark1;
	int mark2;
	int mark3;
	Student(int roll,int mark1,int mark2,int mark3)
	{
		super("mano","female","mano@1","chennai",5874857);
		this.roll=roll;
		this.mark1=mark1;
		this.mark2=mark2;
		this.mark3=mark3;
		
	}
	public void disS()
	{
		System.out.println("Roll no    :"+roll);
		System.out.println("Mark1      :"+mark1);
		System.out.println("Mark2      :"+mark2);
		System.out.println("Mark3      :"+mark3);
		System.out.println("********************");
	}

}
