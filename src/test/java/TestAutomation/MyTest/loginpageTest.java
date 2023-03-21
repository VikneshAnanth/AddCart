package TestAutomation.MyTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginpageTest extends BaseTest {
	
	
	WebDriver driver;
	@Test
	public void Login() throws IOException
	{
		driver=browserIntialization();
		loginpageObject lp=new loginpageObject(driver);
		lp.goTo();
		lp.login("vigneshananth7@gmail.com", "Udemy@7");
		System.out.println(driver.getTitle());
		
			}
	@AfterTest()
	public void TearDown()
	{
	driver.quit();
	
	}
}
