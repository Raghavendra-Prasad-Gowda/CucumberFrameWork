package pageObjects;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	//Webelement for Clicking the Dismiss 
	@FindBy(how=How.XPATH, using="//p[@class='woocommerce-store-notice demo_store']/a")
	private WebElement dismiss;
	
	//Webelement for Search Button
	@FindBy(how=How.XPATH, using="//a[@class='noo-search']/i")
	private WebElement searchButton;
	
	//Webelement for Clicking Search Text Box
	@FindBy(how=How.XPATH, using="//input[@type='search']")
	private WebElement searchTextBox;
	
	
	public HomePage(WebDriver driver) {
		
		//Initiating the driver og Home page class
		this.driver=driver;
		
		//Instantiating the Pagefactory 
		PageFactory.initElements(driver, this);
			
	}
	
	
	//Below are the Methods used in the HomePage
	
	public  void click_Dismiss() {
		dismiss.click();
	}
	
	
	public void click_Search_Icon() {
		searchButton.click();
	}
	
	public void send_Search_Text(String SearchText) {
		searchTextBox.sendKeys(SearchText);
		searchTextBox.sendKeys(Keys.ENTER);
	}
	
	

}
