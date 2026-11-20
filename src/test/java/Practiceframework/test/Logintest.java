package Practiceframework.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Practiceframework.pageobjects.Productspage;
import karthiks.testcomponents.Basetest;

public class Logintest extends Basetest {

	@Test(groups = {"smoke"})
	public void loginSuccessverification() {
		Productspage pp = lp.loginSuccessfully("getkarven@gmail.com", "Admin@123");
		Boolean result = pp.gettextofNumberofMaxItems().trim().equals("User can only see maximum 9 products on a page");
		Assert.assertTrue(result);
	}

	@Test
	public void blankusernameloginverification() throws InterruptedException {
		Boolean result = lp.blankUsernameLogin("Admin@123").equals("*Email is required");
		Assert.assertTrue(result);

	}

	@Test
	public void blankpasswordloginverification() throws InterruptedException {
		
		Boolean result = lp.blankPasswrodLogin("getkarven@gmail.com").equals("*Password is required");
		Assert.assertTrue(result);
	}
		
		
		
		@Test
		public void blankpasswordloginverificationfailtestcase() throws InterruptedException {
			
			Boolean result = lp.blankPasswrodLogin("getkarven@gmail.com").equals("*Password is not required");
			Assert.assertTrue(result);
		
		
		
		

	}

}
