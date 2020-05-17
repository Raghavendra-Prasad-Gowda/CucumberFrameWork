package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;

public class PageObjectManager {
	
	private WebDriver driver;
	private ProductListingPage productListingPage;
	private CartPage cartPage;
	private CheckOutPage checkOutPage;
	private HomePage homePage;
	
	
	//Constrcutor to initialize to the Driver
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public HomePage getHomePageObject() {
		if(homePage==null) {
			homePage=new HomePage(driver);
		}
		return homePage;		
	}
	
	public CartPage getCartPageObject() {
		if(cartPage==null) {
			cartPage=new CartPage(driver);
		}	
		return cartPage;		
	}
	
	public CheckOutPage getCheckOutPageObject() {
		if(checkOutPage==null) {
			checkOutPage = new CheckOutPage(driver);
		}
		return checkOutPage;
	}
	
	public ProductListingPage getProductListingPageObject() {
		if(productListingPage==null) {
			productListingPage=new ProductListingPage(driver);
		}
		return productListingPage;
	}
	

}
