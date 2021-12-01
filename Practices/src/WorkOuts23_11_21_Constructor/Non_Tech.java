package WorkOuts23_11_21_Constructor;

public class Non_Tech extends Tech_P {
	String sub1;
	
	Non_Tech(String sub1)
	{
		
		super(103,2,"nontech","bsc",45456);
		this.sub1=sub1;
	}
	public void disNT()
	{
		System.out.println("Subject 1  :"+sub1);
		System.out.println("********************");

	}

}
