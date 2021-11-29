package TestChecking;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("when running  MathTest")
class MathTestTest {
	MathTest mt;
	TestInfo ti;
	TestReporter tr;
	@BeforeEach
	void init(TestInfo ti,TestReporter tr)
	{
		this.ti=ti;
		this.tr=tr;
		mt=new MathTest();
	}
	@Nested
	@DisplayName("Add")
	@Tag("math")
	class AddTest{
		@Test
		@DisplayName("postiveNumber")
	void testAddPosi()
	{
		assertEquals(2,mt.add(1, 1),"should return postive value");
	}
		@Test
		@DisplayName("NegativeNumber")
	void testAddNega()
	{
			int ex=-2;
			int act=mt.add(-1, -1);
		assertEquals(ex,act,()->"should return sum"+ex+"but"+act);
	}
	}
	@Test
	@Tag("math")
	@DisplayName("multiple method")
	void testMul()
	{
		System.out.println();
		tr.publishEntry("Running"+ti.getDisplayName()+"with tags"+ti.getTags());
		assertAll(
				() ->assertEquals(0,mt.mul(1, 0)),
				()->assertEquals(-2,mt.mul(2, -1)),
				() -> assertEquals(6,mt.mul(2, 3))
				);
	}
	
	@RepeatedTest(2)
	void testComputeCircle(RepetitionInfo ri)
	{
		ri.getCurrentRepetition();
		//assumeTrue(false);
		assertEquals(314.1592653589793,mt.CircleArea(10),"The given value is not same as circle value");
	}
/*
 @BeforeAll
 
static void beforeallinit()
{
	System.out.println("this needs to run before all");
}

@AfterEach
void clean()
{
	System.out.println("cleaning up....");
}
	@Test
	@DisplayName("this is add method ")
	void testAdd() {
		//System.out.println("this is a test case");
		
		int exce=2;
		int act=mt.add(1, 1);
		assertEquals(exce,act,"Add two numbers  which is not excepted output");
	}
	
	@Test
	@Disabled("This method doesnt work")
	void testDivi()
	{
		 MathTest mt=new MathTest();
		 assertThrows(ArithmeticException.class, () -> mt.divide(1, 0),"Divided by zero");
	}
*/
}
