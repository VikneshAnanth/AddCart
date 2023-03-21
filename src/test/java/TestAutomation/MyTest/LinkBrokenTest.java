package TestAutomation.MyTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LinkBrokenTest extends BaseTest {
WebDriver driver;
	@Test
	public void verifyLinks() throws IOException
	{
		driver=browserIntialization();
		driver.get("https://rahulshettyacademy.com/client");
		List<WebElement> lis=driver.findElements(By.tagName("a"));
Iterator<WebElement> it=lis.iterator();
while(it.hasNext())
{
	String url=it.next().getAttribute("href");
try
{
	HttpURLConnection connection=(HttpURLConnection)new URL(url).openConnection();
	connection.setConnectTimeout(5000);
	connection.connect();
	int rescode=connection.getResponseCode();
	if(rescode>400)
	{
		System.out.println(url+" "+connection.getResponseMessage()+" is broken link");
	}else {
		System.out.println(url+" "+connection.getResponseMessage());	
	}
	
}
catch(Exception e)
{
	e.printStackTrace();
}


}driver.quit();

	}
}