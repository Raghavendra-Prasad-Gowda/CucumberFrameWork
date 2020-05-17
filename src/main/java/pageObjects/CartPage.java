package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
	
	@FindBy(how=How.XPATH, using="//i[@class='icon_bag_alt']")
	private WebElement miniCartIcon;
	
	
	@FindBy(how=How.XPATH, using="//a[@class='checkout-button button alt wc-forward']")
	private WebElement checkOutButton;
	
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Methods on Cart Page
	
	public void click_On_Mini_Cart_Icon() {
		miniCartIcon.click();
	}
	
	public void click_Checkout_Button() {
		checkOutButton.click();
	}

}
