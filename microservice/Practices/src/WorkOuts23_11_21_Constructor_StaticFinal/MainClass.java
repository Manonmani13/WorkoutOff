package WorkOuts23_11_21_Constructor_StaticFinal;


public class MainClass {
	public static void main(String[] args) {
		System.out.println("             Student Details List               \n");
		Student s=new Student(98,30, 88, 45);
		s.disP();
		s.disS();
		Tech t=new Tech("mano","female","mano@1","chennai",84,3,454345,"teacher","bcom",495784,"c","c++","java");
		System.out.println("               Teacher Details List              \n");
		t.disP();
		t.disTP();
		t.disT();
		Non_Tech nt=new Non_Tech("maha","female","maha@1","chennai",746574, 112,
				4, "nontech", "bsc", 5454.04, "java");
		System.out.println("              Non-Tech Details List              \n");

		nt.disP();
		nt.disTP();
		nt.disNT();

	}

}
