package TestAutomation.MyTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpageObject {

	WebDriver driver;
	public loginpageObject(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(css=".login-btn")
	WebElement loginButton;
	
	public void login(String UserName,String Password)
	{
		email.sendKeys(UserName);
		password.sendKeys(Password);
		loginButton.click();
		
	}
}
