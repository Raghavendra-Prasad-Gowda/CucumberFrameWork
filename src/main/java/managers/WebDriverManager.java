package managers;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import configDataProvider.ConfigurationFileReader;
import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager {
	
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static FileReaderManager fileReaderManager;
	private static ConfigurationFileReader configMethods;
	
	private static final String CHROME_DRIVER_PROPERTY="webdriver.chrome.driver";
	private static final String FIREFOX_DRIVER_PROPERTY="webdriver.gecko.driver";
	private static final String INTERNETEXPLORER_DRIVER_PROPERTY="webdriver.ie.driver";
	
	public WebDriverManager() throws IOException {
		fileReaderManager=new FileReaderManager();
		configMethods=fileReaderManager.getConfigProperties();
		
		driverType =configMethods.getBrowser();
		environmentType=configMethods.getEnvironmentType();
	}
	
	public WebDriver getDriver() throws IOException {
		
		if(driver==null) {
			driver=createDriver();
			return driver;
		}else {
			return driver;
		}
	}
	
	
	private WebDriver createDriver() throws IOException {
		switch(environmentType) {
		case LOCAL: 
			driver=createLocalDriver();
			break;
		
		case REMOTE: 
			driver=createRemoteDriver();
			break;
		}
		return driver;
	}
	
	
	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}
	
	private WebDriver createLocalDriver() throws IOException {
		
		switch(driverType) {
		
		case FIREFOX : 
			System.setProperty(FIREFOX_DRIVER_PROPERTY, configMethods.getFirefoxDriverPath());
			driver = new FirefoxDriver();
		    break;
		
		case CHROME: 
			System.setProperty(CHROME_DRIVER_PROPERTY, configMethods.getChromeDriverPath());
			driver = new ChromeDriver();
		    break;
		
		case INTERNETEXPLORER: 
			System.setProperty(INTERNETEXPLORER_DRIVER_PROPERTY, configMethods.getInternetExplorerDriverPath());
			driver = new InternetExplorerDriver();
			break;
		}
		
		return driver;
	}
	

	public void closeDriver() {
		driver.close();
		driver.quit();
	}
}
