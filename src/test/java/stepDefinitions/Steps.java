package stepDefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import configDataProvider.ConfigurationFileReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;
import net.bytebuddy.utility.RandomString;
import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;

public class Steps {
	// To mainatin a Single Instance of WebDriver hence Static is used
	static WebDriver driver;

	// To generate Random String
	RandomString rs;

	// Configuration Manager ObjectVariable
	FileReaderManager fileReaderManager;

	// Object Variable for getting Config Values
	ConfigurationFileReader configValues;

	// Creating Object for WebDriver Manager
	WebDriverManager webDriverManager;

	// Creating the Object Variable for Page Object Manager
	PageObjectManager pageObjManager;

	// PageObject Variables
	CartPage cartpage;
	CheckOutPage checkoutpage;
	HomePage homepage;
	ProductListingPage productlistpage;

	// Step Defenitions
	@Given("^User is on the home page$")
	public void user_is_on_the_home_page() throws IOException {
		// Create the Object for Configuration File Reader
		fileReaderManager = new FileReaderManager();
		configValues = fileReaderManager.getConfigProperties();

		// Creating the WebDriver
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();

		// Navigating to the URL
		driver.get(configValues.getAppURL());
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(configValues.getImplicitWait(), TimeUnit.SECONDS);

		// Creating Object for Page Object Manager
		pageObjManager = new PageObjectManager(driver);

		// Getting the HomePage Object from Page Object Manager
		homepage = pageObjManager.getHomePageObject();
		homepage.click_Dismiss();
	}

	@When("^he search for dress by clicking the search button$")
	public void he_search_for_by_clicking_the_search_button() {

		// Clicking on Search Button
		homepage.click_Search_Icon();

		// Send Keys to search Bar
		homepage.send_Search_Text("Dress");

	}

	@When("^choose the first item among the displayed results$")
	public void choose_the_first_item_among_the_displayed_results() throws InterruptedException {

		// Getting product Listing Page Object from Page Object Manager
		productlistpage = pageObjManager.getProductListingPageObject();

		Thread.sleep(5000);
		// Press the dress material which is appearing first'
		productlistpage.select_Products_From_List(0);

		// Select the Color
		productlistpage.select_From_Color_DropDown("white");

		// Select the Size
		productlistpage.select_From_Size_Dropdown("small");

		// Select the Quantity Icon
		productlistpage.increase_Quantity(1);

		// Click Add to card button
		productlistpage.click_Add_To_Cart_Button();

	}

	@When("^moves to checkout from mini cart icon at top right corner$")
	public void moves_to_checkout_from_mini_cart_icon_at_top_right_corner() {

		// Getting product Cart Page Object from Page Object Manager
		cartpage = pageObjManager.getCartPageObject();

		// Clicking on MiniCart Icon
		cartpage.click_On_Mini_Cart_Icon();

		// Proceeding to checkout
		cartpage.click_Checkout_Button();

	}

	@When("^enter the personal details on checkout page$")
	public void enter_the_personal_details_on_checkout_page() {

		// Getting Checkout Page Object from Page Object Manager
		checkoutpage = pageObjManager.getCheckOutPageObject();

		// filling the first name for billing
		checkoutpage.billing_First_Name_Textbox(RandomString.make(10));

		// filling last name
		checkoutpage.billing_LastName_Textbox(RandomString.make(5));

		// Company Name
		checkoutpage.billing_Company_Textbox(RandomString.make(8));

		// Click on the Country Part
		checkoutpage.billing_CountryTextbox("India");

		// Entering the billing Address
		checkoutpage.billing_Address_Textbox(RandomString.make(9));

		// Entering City
		checkoutpage.billing_City_Textbox("Mysore");

		// Entering the State
		checkoutpage.state_TextBox("Karnataka");

		// Entering the Pincode
		checkoutpage.billing_Postcode_Textbox("571301");

		// Entering Phone
		checkoutpage.billing_Phone_Textbox("7894561237");

		// Entering the Email
		checkoutpage.billing_Email_Textbox(RandomString.make(10) + "@gmail.com");

	}

	@When("^place the order$")
	public void place_the_order() throws InterruptedException {

		checkoutpage.click_terms_Conditions_Checkbox();
		checkoutpage.checkout_Place_Order();
		webDriverManager.closeDriver();

	}

}
