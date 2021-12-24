package WorkOuts23_11_21;

public class MainClass {
public static void main(String[] args) {
	Student s=new Student();
	System.out.println("             Student Details List               \n\n");
	s.detailsP("mano","female","mano@gmail.com","chennai",9898605);
	s.disP();
	s.detailS(10, 88, 45, 67);
	s.disS();
	Tech t=new Tech();
	System.out.println("               Teacher Details List              \n\n");
	t.detailsP("kala","female","kala@gmail.com","Chennai",49859);
	t.disP();
	t.detailtp(112,4,"teacher","Bcs",67984);
	t.disTP();
	t.detailT("cs","c","c++");
	t.disT();
	Non_Tech nt=new Non_Tech();
	System.out.println("              Non-Tech Details List              \n\n");
	nt.detailsP("manoo","female","mano@gmail.com","chennai",9898605);
	nt.disP();
	nt.detailtp(112,4,"teacher","Bcs",67984);
	nt.disTP();
	nt.detailNT("java");
	nt.disNT();
	
}
}
