package TestAutomation.MyTest;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LinksWorkouts {
	WebDriver driver;
	public LinksWorkouts(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	public void getLinks() {
		List<WebElement> firstLinks=driver.findElements(By.xpath("//div[@class='navFooterLinkCol navAccessibility'][1]/ul"));
	List<String> links=firstLinks.stream().map(s->s.getText()).collect(Collectors.toList());
			
		System.out.println(links);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		LinksWorkouts obj=new LinksWorkouts(driver);
		obj.getLinks();
		driver.quit();
	}

}
