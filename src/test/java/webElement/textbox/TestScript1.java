package webElement.textbox;

import org.testng.annotations.Test;

public class TestScript1 {
	
	
	@Test(priority = 4, invocationCount = 3)
	public void testCase1() {
		
		System.out.println("This is test case 1");
		
	}
	
	@Test(priority = 2)
	public void testCase2() {
		
		System.out.println("This is test case 2");
		
	}
	
	@Test(priority = 1, dependsOnMethods = "testCase2")
	public void testCase3() {
		
		System.out.println("This is test case 3");
		
	}
	
	@Test(priority = 3, enabled = false)
	public void testCase4() {
		
		System.out.println("This is test case 4");
		
	}

}
