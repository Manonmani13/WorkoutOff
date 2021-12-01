package WorkOuts23_11_21_Constructor_StaticFinal;

public class Person {
	String name;
	String gender;
	String email;
	String city;
	int phone;
	final static String college="Asan memorial college";
	
	Person(String name,String gender,String email,String city,int phone)
	{
		this.name=name;
		this.gender=gender;
		this.email=email;
		this.city=city;
		this.phone=phone;
	}
	public void disP()
	{
		System.out.println("Name       :"+name);
		System.out.println("Gender     :"+gender);
		System.out.println("Mail       : "+email);
		System.out.println("City       :"+city);
		System.out.println("Phone no   :"+phone);
		System.out.println("College    :"+college);
		
	}
}
