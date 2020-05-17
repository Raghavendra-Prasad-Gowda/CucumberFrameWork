package managers;

import java.io.IOException;

import configDataProvider.ConfigurationFileReader;

public class FileReaderManager {
	
	private ConfigurationFileReader confProp;
	
	
	public ConfigurationFileReader getConfigProperties() throws IOException {
		
		if(confProp==null) {
			confProp = new ConfigurationFileReader();
			return confProp;
		}else {
			throw new RuntimeException("There is an Issue while Instantiating from Config File");
		}
		
	}
	

}
