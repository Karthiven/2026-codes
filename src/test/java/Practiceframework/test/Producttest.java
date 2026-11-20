package Practiceframework.test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Practiceframework.pageobjects.Loginpage;
import Practiceframework.pageobjects.Productspage;
import io.github.bonigarcia.wdm.WebDriverManager;
import karthiks.testcomponents.Basetest;

public class Producttest extends Basetest {
	
	
	
	@Test(groups = {"smoke"})
     public void addsingleProducttoCarttest() throws InterruptedException, IOException
	 {
	
		Productspage pp=lp.loginSuccessfully("getkarven@gmail.com", "Admin@123");
		pp.printAllAvailableProducts();
		pp.addOneProduct("ZARA COAT 3");
		

	}
	
	@Test(dependsOnMethods = {"addsingleProducttoCarttest"})
	public void addmultipleProducttoCarttest() throws InterruptedException
	{
		Productspage pp=lp.loginSuccessfully("getkarven@gmail.com", "Admin@123");
		pp.printAllAvailableProducts();
		pp.addTwoProduct("ZARA COAT 3", "ADIDAS ORIGINAL");
	}
	
	

}
