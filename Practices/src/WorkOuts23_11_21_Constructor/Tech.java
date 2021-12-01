package WorkOuts23_11_21_Constructor;

public class Tech  extends Tech_P {
	String sub1;
	String sub2;
	String sub3;
	Tech(String sub1,String sub2,String sub3)
	{
		super(123,3,"teacher","bcom",34676);
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
