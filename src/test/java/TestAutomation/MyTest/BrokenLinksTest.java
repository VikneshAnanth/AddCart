package TestAutomation.MyTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BrokenLinksTest extends BaseTest{
WebDriver driver;

	@Test
	public void getBrokenLink() throws IOException
	{
		driver=browserIntialization();
		driver.get("https://rahulshettyacademy.com/client/");
		List<WebElement> links=driver.findElements(By.tagName("a"));
		Iterator <WebElement> it=links.iterator();
		while(it.hasNext())
		{
			String url=it.next().getAttribute("href");
			System.out.println(url);
			try
			{
				HttpURLConnection connection=(HttpURLConnection) new URL(url).openConnection();
				connection.setRequestMethod("HEAD");
				connection.connect();
				
				int responceCode=connection.getResponseCode();
				SoftAssert as=new SoftAssert();
				as.assertTrue(responceCode>400,"this link is"+url+" is broken with "+responceCode);
				as.assertAll();
				
			}catch(MalformedURLException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
		}
		
		
		driver.quit();
	}
	
}
