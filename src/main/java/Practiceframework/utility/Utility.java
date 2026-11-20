package Practiceframework.utility;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {

	WebDriver driver;

	public Utility(WebDriver driver) {

		this.driver = driver;

	}

	
	
	
	public void waituntillocatorvisible(By locator)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waituntilelementvisible(WebElement ele)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	
	public void waituntilAllelementsvisble(List<WebElement> items)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfAllElements(items));
	}
	
	public void waituntilAllelementsvisblebyloc(By loc)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(loc));
	}
	
	
	
	public void waituntilelementinvisible(By locator)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	
	}
	

	public void waituntilelementinvisibleeasy(WebElement ele)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void waituntilAllelementvisbleeasy(By locator)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	
	public void waituntilelementtobeclickable(By locator)
	{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void wow() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(webDriver ->
		    ((JavascriptExecutor) webDriver)
		        .executeScript("return document.readyState")
		        .equals("complete")
		);
	}
}
