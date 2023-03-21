package TestAutomation.MyTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BaseTest {

	WebDriver driver;
	
	
	
	public WebDriver browserIntialization() throws IOException
	{
		//WebDriverManager.firefoxdriver().setup();
		Properties prop= new Properties();
		FileInputStream io=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\TestAutomation\\MyTest\\parameters.Properties"); 
		prop.load(io);
		String Browsername=prop.getProperty("Browser");
		if(Browsername.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else if(Browsername.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			
		}
		
		else if(Browsername.equalsIgnoreCase("firefox"))
		{
		driver=new 	InternetExplorerDriver();
		
		}
		
		else if(Browsername.contains("headless"))
		{
			ChromeOptions options=new ChromeOptions();
			options.addArguments("headless");
			driver=new ChromeDriver(options);
					}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
}
	 
		
		public  void loginpage(String UserName,String Password ) throws IOException
		{
		driver=	browserIntialization();
			loginpageObject lp=new loginpageObject(driver);
			lp.goTo();
			lp.login(UserName, Password);
			
		}
		
		
	}
