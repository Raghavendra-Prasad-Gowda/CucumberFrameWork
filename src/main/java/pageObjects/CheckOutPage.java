package pageObjects;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class CheckOutPage {

	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//input[@name='billing_first_name']")
	private WebElement billingFirstNameTextbox;

	@FindBy(how = How.XPATH, using = "//input[@name='billing_last_name']")
	private WebElement billingLastNameTextbox;

	@FindBy(how = How.XPATH, using = "//input[@name='billing_company']")
	private WebElement billingCompanyTextbox;

	@FindBy(how = How.XPATH, using = "//span[@id='select2-billing_country-container']")
	private WebElement billingCountryContainer;

	@FindBy(how = How.XPATH, using = "//input[@class='select2-search__field']")
	private WebElement billingcountryTextBox;

	@FindBy(how = How.XPATH, using = "//input[@name='billing_address_1']")
	private WebElement billingAddressTextbox;

	@FindBy(how = How.XPATH, using = "//input[@name='billing_city']")
	private WebElement billingCityTextbox;

	@FindBy(how = How.XPATH, using = "(//span[@class='select2-selection__arrow'])[2]")
	private WebElement arrowSelectionForState;

	@FindBy(how = How.XPATH, using = "//input[@class='select2-search__field']")
	private WebElement billingstateTextBox;

	@FindBy(how = How.XPATH, using = "//input[@name='billing_postcode']")
	private WebElement billingPostcodeTextbox;

	@FindBy(how = How.XPATH, using = "//input[@name='billing_phone']")
	private WebElement billingPhoneTextbox;

	@FindBy(how = How.XPATH, using = "//input[@name='billing_email']")
	private WebElement billingEmailTextbox;

	@FindBy(how = How.XPATH, using = "//input[@name='terms']")
	private WebElement termsCheckBox;

	@FindBy(how = How.XPATH, using = "//button[@name='woocommerce_checkout_place_order']")
	private WebElement checkoutPlaceOrder;

	public CheckOutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	public void billing_First_Name_Textbox(String FirstName) {
		billingFirstNameTextbox.sendKeys(FirstName);

	}

	public void billing_LastName_Textbox(String LastName) {
		billingLastNameTextbox.sendKeys(LastName);
	}

	public void billing_Company_Textbox(String CompanyName) {
		billingCompanyTextbox.sendKeys(CompanyName);
	}

	public void billing_CountryTextbox(String Country) {
		billingCountryContainer.click();
		billingcountryTextBox.sendKeys(Country);
		billingcountryTextBox.sendKeys(Keys.ENTER);
	}

	public void billing_Address_Textbox(String Address) {
		billingAddressTextbox.sendKeys(Address);
	}

	public void billing_City_Textbox(String City) {
		billingCityTextbox.sendKeys(City);
	}

	public void state_TextBox(String State) {
		arrowSelectionForState.click();
		billingstateTextBox.sendKeys(State);
		billingstateTextBox.sendKeys(Keys.ENTER);
	}

	public void billing_Postcode_Textbox(String Pincode) {
		billingPostcodeTextbox.sendKeys(Pincode);
	}

	public void billing_Phone_Textbox(String PhoneNumber) {
		billingPhoneTextbox.sendKeys(PhoneNumber);
	}

	public void billing_Email_Textbox(String Email) {
		billingEmailTextbox.sendKeys(Email);
	}

	public void click_terms_Conditions_Checkbox() throws InterruptedException {
		Thread.sleep(5000);
		Actions termsScroll=new Actions(driver);
		termsScroll.moveToElement(termsCheckBox);
		termsScroll.perform();
		termsCheckBox.click();
		
		
	}

	public void checkout_Place_Order() throws InterruptedException {
		
		checkoutPlaceOrder.click();
		Thread.sleep(10000);
	}

}
