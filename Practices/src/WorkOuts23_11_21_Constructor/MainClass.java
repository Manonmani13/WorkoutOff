package WorkOuts23_11_21_Constructor;


public class MainClass {
public static void main(String[] args) {
	System.out.println("             Student Details List               \n\n");
	Student s=new Student(98,30, 88, 45);
	s.disP();
	s.disS();
	Tech t=new Tech("c","c++","java");
	System.out.println("               Teacher Details List              \n\n");
	t.disP();
	t.disTP();
	t.disT();
	Non_Tech nt=new Non_Tech("accounts");
	System.out.println("              Non-Tech Details List              \n\n");

	nt.disP();
	nt.disTP();
	nt.disNT();

}
}
