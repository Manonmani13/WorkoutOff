package LambdaEx;

@FunctionalInterface
public interface Arithme {//void and int we can use
public int add(int c,int b);
default void test1()
{
	System.out.println("Hi");
}
static void test2()
{
	System.out.println("Welcome");
}
}
