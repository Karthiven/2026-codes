package Practiceframework.pageobjects;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Practiceframework.utility.Utility;

public class Loginpage extends Utility {

	WebDriver driver;
	Productspage pp;
	

	public Loginpage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='userEmail']")
	WebElement username;

	@FindBy(xpath = "//input[@id='userPassword']")
	WebElement password;

	@FindBy(xpath = "//input[@id='login']")
	WebElement loginbutton;
	
	@FindBy(xpath = "//div[@class='invalid-feedback']/div[contains(text(),\"Email\")]")
	WebElement usernameValidationMessage;
	
	@FindBy(xpath = "//div[@class='invalid-feedback']/div[contains(text(),\"Password \")]")
	WebElement passwordValidationMessage;
	
	
	

	public void launchurl(String url) {
		driver.get(url);
	}
	
	public Productspage loginSuccessfully(String Un, String Pwd)
	{
		waituntilelementvisible(username);
		username.sendKeys(Un);

		waituntilelementvisible(password);
		password.sendKeys(Pwd);
		
		waituntilelementvisible(loginbutton);
		loginbutton.click();
		
	    return  new Productspage(driver);
			
	}
	
	public String blankUsernameLogin(String Pwd) throws InterruptedException
	{

		waituntilelementvisible(password);
		password.sendKeys(Pwd);
		
		waituntilelementvisible(loginbutton);
		loginbutton.click();	
		
		//Thread.sleep(2000);
		
		waituntilelementvisible(usernameValidationMessage);
		return usernameValidationMessage.getText();
			
	}
	
	public String blankPasswrodLogin(String Un)
	{

		waituntilelementvisible(username);
		username.sendKeys(Un);
		
		waituntilelementvisible(loginbutton);
		loginbutton.click();
		
		//waituntilelementvisible(passwordValidationMessage);
		return passwordValidationMessage.getText();
		
		
	}
	
	
	

	
	
}
