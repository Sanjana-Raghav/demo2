package test;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import operations.StandardOperations;

public class StandardOperationsTest {
	
	static StandardOperations st;
	StandardOperations so;
	
	public StandardOperationsTest() {
		st =new StandardOperations();
		so= new StandardOperations();
	}
	
	/*@Before  //@Before.... @Test.... @After.. Objects get created in every method(initialized)
	public void sameMethod()
	{
		st=new StandardOperations();
		System.out.println("Object :"+st);
	}
	*/
	
	@BeforeClass  
	public static void sameMethod()
	{
		st=new StandardOperations();
		System.out.println("Object :"+st);
	}
	
	@AfterClass  //@BeforeClass and @AfterClass are like connection created only once and to close the resources at last
	public static void afterMethod()
	{
		st=null;
		System.out.println("die");
	}
	
	@Test
	public void addPositiveValuesTestCase()
	{
		assertEquals(7,st.add(3,4));
	}

	@Test
	public void addMultipleValuesTestCase()
	{
		assertEquals(10,st.add(6,4));
	}

	@Ignore
	@Test
	public void checkPositiveTestCase()
	{
		assertNotNull(st);
		//assertNull(st);
		assertSame(so,so);
		assertNotSame("Not Same", st, so);
		assertTrue(st.checkpositive(45));
	}
	
	@Test/*(expected=Exception.class)*/ //when you want to throw
	public void subNegativeValuesTestCase() throws Exception
	{
		assertEquals(2,st.sub(6,4));
	}
	
	@Test(timeout=900) //It executes time less than this
	public void waitForInputTestCase() throws InterruptedException 
	{
		assertEquals(5,st.waitForInput(5));
	}
}
