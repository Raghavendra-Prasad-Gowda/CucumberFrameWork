package configDataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;
import enums.EnvironmentType;

public class ConfigurationFileReader {
	
	private Properties prop;
	private FileInputStream fis;
	private final String propFilePath="configurations//Configuration.properties";
	
	public ConfigurationFileReader() throws IOException {
		
		try {
			
			fis=new FileInputStream(propFilePath);
			prop=new Properties();	
			prop.load(fis);
		}catch(FileNotFoundException e){
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at "+ propFilePath);
		}
		
	}
	
	public String getChromeDriverPath() {
		String chromeDriverPath=prop.getProperty("chromePath");	
		if(chromeDriverPath!=null) {
		return chromeDriverPath;
		}else {
			throw new RuntimeException("driverPath is not specified in the Configuration.properties");
		}
	}
	
	public String getFirefoxDriverPath() {
		String FirefoxDriverPath=prop.getProperty("firefoxPath");	
		if(FirefoxDriverPath!=null) {
		return FirefoxDriverPath;
		}else {
			throw new RuntimeException("driverPath is not specified in the Configuration.properties");
		}
	}
	
	public String getInternetExplorerDriverPath() {
		String InternetExplorerDriverPath=prop.getProperty("internetexplorerPath");	
		if(InternetExplorerDriverPath!=null) {
		return InternetExplorerDriverPath;
		}else {
			throw new RuntimeException("driverPath is not specified in the Configuration.properties");
		}
	}
	
	public int getImplicitWait() {
		String implicitWaitString=prop.getProperty("implicitWaitTime");		
		if(implicitWaitString!=null) {
			return Integer.parseInt(implicitWaitString);
			}else {
				throw new RuntimeException("implicitWait is not specified in the Configuration.properties");
			}
	}
	
	public String getAppURL() {
		String appURL=prop.getProperty("webURL");
		if(appURL!=null) {
			return appURL;
		}else {
			throw new RuntimeException("appURl is not specified in the Configuration.properties");
		}
		
	}
	
	
	public DriverType getBrowser() {
		String browserName=prop.getProperty("browser");
		
		if(browserName==null || browserName.equals("chrome")) {
			return DriverType.CHROME;
		}else if(browserName.equals("firefox")) {
			return DriverType.FIREFOX;
		}else if (browserName.equals("internetexplorer")) {
			return DriverType.INTERNETEXPLORER;
		}else {
			throw new RuntimeException("Browser name entered is not in the configuration file: "+browserName);
		}
		
	}
	
	
	public EnvironmentType getEnvironmentType() {
		String envType=prop.getProperty("environment");
		if(envType==null || envType.equalsIgnoreCase("local")) {
			return EnvironmentType.LOCAL;
		}else if(envType.equalsIgnoreCase("remote")) {
			return EnvironmentType.REMOTE;
		}else {
			throw new RuntimeException("Envirnonment type entered is not in configuration file: "+envType);
		}
		
	}
		
}
