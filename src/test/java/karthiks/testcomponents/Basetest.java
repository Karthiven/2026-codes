package karthiks.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.security.PublicKey;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.Flow.Publisher;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Practiceframework.pageobjects.Loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {
	
	public WebDriver driver;
	public Loginpage lp;
	
	
	
	
	public void initializeDriver() throws IOException
	{
		
		/*Properties prop = new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\karthiks\\resources\\Config.properties");
		prop.load(fis);*/
		
		String browserused=configReader("browser");
		
		
		if(browserused.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		 driver= new ChromeDriver();
		
		}else if(browserused.equals("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();	
		}
		
		
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void launchApp() throws IOException
	
	{
		/*Properties prop = new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\karthiks\\resources\\Config.properties");
		prop.load(fis);*/
		String baseurlString=configReader("url");
		
		initializeDriver();
	    lp = new Loginpage(driver);
		lp.launchurl(baseurlString);
		
		//return lp;
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		driver.quit();
	}
	
	
	//some Function that we use in frame work
	
		
	public String configReader(String neededdata) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\karthiks\\resources\\Config.properties");
		prop.load(fis);
		String propvalue=System.getProperty(neededdata)!=null ? System.getProperty(neededdata) : prop.getProperty(neededdata);	
		return propvalue;
	}
	
	public  String getScreenshot(String testcasename, WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst= new File(System.getProperty("user.dir")+"//Reports//"+testcasename+".png");
		FileUtils.copyFile(src,dst );
		
		return System.getProperty("user.dir")+"//Reports//"+testcasename+".png";
		
				
	
	}
		


}
