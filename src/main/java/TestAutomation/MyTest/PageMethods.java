package TestAutomation.MyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageMethods {
	
	WebDriver driver;
	WebDriverWait wait; 
	public PageMethods(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public abstract String getTitle();
	public abstract WebElement getElement(By locator);
	public abstract void waitForElement(By locator);
	
	public <Spage extends BasePage> Spage getInstance(Class<Spage> pageclass) {
		try {
		return pageclass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
	}catch(Exception e)
		{
		e.printStackTrace();
		}
		return null;
	
}
}