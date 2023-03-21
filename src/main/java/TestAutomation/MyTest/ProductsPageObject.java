package TestAutomation.MyTest;



import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestAutomation.AbstractComponent.AbstractComponent;

public class ProductsPageObject extends AbstractComponent {

	WebDriver driver;
	
	public ProductsPageObject(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".mb-3")
	List<WebElement> productCatalogue;
	
	By productsBy=By.cssSelector(".mb-3");
	By pname=By.cssSelector("b");
	
	By addCart=By.cssSelector(".card-body button:last-of-type");
	
	@FindBy(id="toast-container")
	WebElement toastMessage;
	//By toastMessage=By.id("toast-container");
	
	
	
	@FindBy(css=".btn.w-40.rounded")
	WebElement viewButton;
	
	@FindBy(css=".card-body div")
	WebElement price;
	
	@FindBy(xpath="//*[@class='fa fa-home']")
	WebElement home;
	
	@FindBy(xpath="//*[@class='fa fa-handshake-o']")
	WebElement orders;
	
	@FindBy(xpath="//*[@class='fa fa-shopping-cart']")
	WebElement shoppingCart;
	
	@FindBy(xpath="//*[@class='fa fa-sign-out']")
	WebElement logout;
	
	public List<WebElement> getProducts()
	{
		visibilityOfElementLocated(productsBy);
		return productCatalogue;
		 
	}
	
	public WebElement getProductName(String Productname)
	{
	WebElement prod=	getProducts().stream().filter(product->product.findElement(pname).getText().equalsIgnoreCase(Productname)).findFirst().orElse(null);
			return prod;	
		
	}
	
	public void addCart(String Productname) throws InterruptedException {
	WebElement prod=	getProductName(Productname)	;
	prod.findElement(addCart).click();
	Thread.sleep(4000);
	//Assert.assertTrue(visibility(toastMessage));
	System.out.println("The product added to cart");
	}
}
