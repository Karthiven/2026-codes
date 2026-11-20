package karthiks.Practiceframework;

import java.lang.annotation.ElementType;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.ForkJoinPool.ManagedBlocker;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scrapperbase {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		//Thread.sleep(2000);
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userEmail']")));
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("getkarven@gmail.com");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userPassword']")));
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Admin@123");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login']")));
		driver.findElement(By.xpath("//input[@id='login']")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='card-body']")));
	List <WebElement> products	= driver.findElements(By.xpath("//div[@class='card']"));
	
	int i=1;
	for(WebElement ele: products)
	{
		
		//System.err.println(ele.findElement(By.xpath(".//div[@class='card-body']/descendant::h5/b")).getText());
		String cuurentproductname=ele.findElement(By.xpath(".//div[@class='card-body']/descendant::h5/b")).getText();
		
		if(cuurentproductname.trim().equals("ZARA COAT 3"))
		{
			driver.findElement(By.xpath("(.//div[@class='card-body']/descendant::button[@class='btn w-10 rounded'])["+i+"]")).click();
			
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Product Added To Cart']")));
			System.out.println("element : "+ cuurentproductname  +" : found and added");
			
			i++;
			//Thread.sleep(2000);
			break;
		}
		else {
			i++;
		}
	}

	
	driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='My Cart']")));
	System.out.println("landed on My cart page");
	Thread.sleep(1000);
	//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Checkout']")));	
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//button[text()='Checkout']"))).build().perform();
	
	
	driver.findElement(By.xpath("//button[text()='Checkout']")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=' Payment Method ']")));
	System.out.println("landed on Payment page");
	
	
	driver.findElement(By.xpath("(//input[@class='input txt'])[1]")).sendKeys("123");
	driver.findElement(By.xpath("(//input[@class='input txt'])[2]")).sendKeys("username");
	//driver.findElement(By.xpath("//input[@fdprocessedid='arugnj']")).sendKeys("123A");
	//driver.findElement(By.xpath("//input[@fdprocessedid='ywwfec']")).sendKeys("getkarven@gmail.com");
	driver.findElement(By.xpath("(//input[@class='input txt text-validated'])[2]")).sendKeys("india");
	driver.findElement(By.xpath("//span[text()=' India']")).click();
	
	act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Place Order ')]"))).build().perform();
	driver.findElement(By.xpath("//a[contains(text(),'Place Order ')]")).click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()=' Thankyou for the order. ']")));
	
	System.out.println("Success");
	
	
	
driver.quit();
		
		

	}

}
