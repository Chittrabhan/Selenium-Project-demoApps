package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		//Converting the physical representation of property file into Java representation
		FileInputStream fis = new FileInputStream("D:\\demoApps\\src\\test\\resources\\testData\\ExcelData.xlsx");
	
		Properties prop = new Properties();
		//Reading the key value pair
		prop.load(fis);
		
		//Calling the value using the key
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		String email = prop.getProperty("email");
		String password = prop.getProperty("password");

		//Printing the value
		System.out.println(browser);
		System.out.println(url);
		System.out.println(email);
		System.out.println(password);

	}

}
