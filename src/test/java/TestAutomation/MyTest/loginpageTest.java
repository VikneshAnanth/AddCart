package TestAutomation.MyTest;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginpageTest {
	WebDriver driver;
	@Test
	public void browserIntialization()
	{
		//WebDriverManager.firefoxdriver().setup();
		 driver=new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/client");
		
	}
	@Test(dataProvider = "credentials")
	public void loginpage(String UserName,String Password )
	{
		//browserIntialization();
		loginpageObject lp=new loginpageObject(driver);
		lp.login(UserName, Password);
	}
	@Test
	@DataProvider(name="credentials")
	public Object[][] getData()
	{
		Object data[][]=new Object[1][2];
		data[0][0]="vigneshananth7@gmail.com";
		data[0][1]="Udemy@7";
	return data;	
	}
}
