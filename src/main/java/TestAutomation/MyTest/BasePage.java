package TestAutomation.MyTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends PageMethods {

	public BasePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
	
		return driver.getTitle();
	}

	@Override
	public WebElement getElement(By locator) {
		// TODO Auto-generated method stub
		WebElement element=null;
		try {
			element=driver.findElement(locator);
			return element;
		}catch(Exception e)
		{
			System.out.println(locator.toString());
		e.printStackTrace();
		}return element;
	}

	@Override
	public void waitForElement(By locator) {
		
	}

}
