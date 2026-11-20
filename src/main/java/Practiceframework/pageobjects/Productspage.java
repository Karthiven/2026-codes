package Practiceframework.pageobjects;

import java.net.URL;
import java.security.PublicKey;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Practiceframework.utility.Utility;

public class Productspage extends Utility {

	WebDriver driver;

	public Productspage(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[contains(@class,'mb-3')]")  
	List <WebElement> products;

	By productsby= By.xpath("//div[contains(@class,'mb-3')]");
	
	
	@FindBy (xpath = "//div[@aria-label='Product Added To Cart']")
	WebElement successmessageflash;
	
	@FindBy (xpath = "//label[contains(text(),\" User can only see maximum 9 products on a page\")]")
	WebElement labelonmaxitemsnumber;
	
	
	public List<WebElement> getproductList()
	{
		waituntilAllelementsvisblebyloc(productsby);
		return products;
	}
	
	public void printAllAvailableProducts() throws InterruptedException
	{
		 Thread.sleep(1000);

		for(WebElement ele:  getproductList())
		{
			String cuurentproductname=ele.findElement(By.xpath(".//div[@class='card-body']/descendant::h5/b")).getText();
			System.out.println(cuurentproductname);
			
		}
	}
	
	public void addOneProduct( String name)
	{
		 waituntilAllelementsvisble(products);
		  
		  int i=1;
			for(WebElement ele: products)
			{
				String cuurentproductname=ele.findElement(By.xpath(".//div[@class='card-body']/descendant::h5/b")).getText();
				
				if(cuurentproductname.trim().equals(name))
				{
					driver.findElement(By.xpath("(.//div[@class='card-body']/descendant::button[@class='btn w-10 rounded'])["+i+"]")).click();
					
					waituntilelementvisible(successmessageflash);
					//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Product Added To Cart']")));
					System.out.println("element : "+ cuurentproductname  +" : found and added");
					
					i++;
					
					break;
				}
				else {
					i++;
				}
				
			}
	}
	
	
	public void addTwoProduct( String name1, String name2)
	{
		 waituntilAllelementsvisble(products);
		  
		  int i=1;
			for(WebElement ele: products)
			{
				String cuurentproductname=ele.findElement(By.xpath(".//div[@class='card-body']/descendant::h5/b")).getText();
				
				if(cuurentproductname.trim().equals(name1)||cuurentproductname.trim().equals(name2))
				{
					driver.findElement(By.xpath("(.//div[@class='card-body']/descendant::button[@class='btn w-10 rounded'])["+i+"]")).click();
					
					waituntilelementvisible(successmessageflash);
					//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Product Added To Cart']")));
					System.out.println("element : "+ cuurentproductname  +" : found and added");
					
					i++;
					
				//	break;
				}
				else {
					i++;
				}
				
			}
	}
	
	public String gettextofNumberofMaxItems()
	{
		return labelonmaxitemsnumber.getText();
		
	}




	

	
	
}
