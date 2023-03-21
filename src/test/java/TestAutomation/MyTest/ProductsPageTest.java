package TestAutomation.MyTest;

import java.io.IOException;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ProductsPageTest extends BaseTest {
	WebDriver driver;
	



@Test
	public void productsVerify() throws IOException, InterruptedException
	{
	driver=browserIntialization();
	String Productname = "iphone 13 pro";
	loginpageObject lp=new loginpageObject(driver);
	lp.goTo();
	ProductsPageObject ppTest=lp.login("vigneshananth7@gmail.com", "Udemy@7");
	List<WebElement> products=	ppTest.getProducts();
ppTest.addCart(Productname);


//Assert.assertTrue(ppTest.toastMessage.isDisplayed());
	//System.out.println("The product added to cart");
		
		
	}
@AfterTest
public void teardown() {
	driver.quit();
}
}
