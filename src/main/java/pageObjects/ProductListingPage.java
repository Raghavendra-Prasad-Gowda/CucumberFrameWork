package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductListingPage {

	WebDriver driver;
	// WebElement for List of Products
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='noo-product-inner']/h3/a"))
	private List<WebElement> products_List;

	// Webelement for ColorDropdown
	@FindBy(how = How.XPATH, using = "//select[@id='pa_color']")
	private WebElement colorDropDown;

	// Webelement for SizeDropdown
	@FindBy(how = How.XPATH, using = "//select[@id='pa_size']")
	private WebElement sizeDropDown;

	// Webelement for Quantity Icon (+)
	@FindBy(how = How.XPATH, using = "//button[@class='qty-increase']/i[@class='icon_plus']")
	private WebElement increaseQuantity;

	// WebElement for addToCartButton Icon
	@FindBy(how = How.XPATH, using = "//button[@class='single_add_to_cart_button button alt']")
	private WebElement addToCartButton;

	public ProductListingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	// Methods for Interacting with Product Page

	public void select_Products_From_List(int product_Number) {
		if (product_Number <= products_List.size()) {
			for (int i = 0; i < products_List.size(); i++) {

				if (product_Number == i) {
					products_List.get(i).click();
					break;
				}

			}
		} else {
			System.out.println("Product Number Out of Range");
		}

	}

	public void select_From_Color_DropDown(String colorValue) {
		Select colorList = new Select(colorDropDown);
		colorList.selectByValue(colorValue);

	}

	public void select_From_Size_Dropdown(String sizeValue) {
		Select sizeList = new Select(sizeDropDown);
		sizeList.selectByValue(sizeValue);
	}

	
	public void increase_Quantity(int quantityValue) {

		if (quantityValue >= 0) {
			for (int j = 0; j < quantityValue; j++) {

				increaseQuantity.click();

			}
		} else {
               System.out.println("Please insert value >=0 for quantity");
		}

	}
	
	public void click_Add_To_Cart_Button() {
		addToCartButton.click();
	}

}
