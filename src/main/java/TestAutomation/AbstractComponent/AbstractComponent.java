package TestAutomation.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	WebDriver driver;
	
	WebDriverWait wait;
	public AbstractComponent(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
	}


	public void visibilityOfElementLocated(By productsBy)
	{
		 wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productsBy));
	
	}
	
	
	public boolean visibility(WebElement element)
	{
		WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(4));
		wait2.until(ExpectedConditions.visibilityOf(element));
		return true;
	}
	
}
