package genericUtils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClass {
	public WebDriver driver;
	public FileUtility fUtils = new FileUtility();

	@BeforeSuite
	public void bs() {
		System.out.println("this is before suite");
	}

	@BeforeClass
	public void bc() throws IOException {
		
		String browser = fUtils.fetchDataFromPropertyFile("browser");
		String url = fUtils.fetchDataFromPropertyFile("url");
		
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		}

		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		System.out.println("this is before class");
	}

	@BeforeMethod
	public void bm() {
		System.out.println("this is before method");
	}

	@AfterMethod
	public void am() {
		System.out.println("this is after method");
	}

	@AfterClass
	public void ac() {
		driver.quit();

		System.out.println("this is after class");
	}

	@AfterSuite
	public void as() {
		System.out.println("this is after suite");
	}
	
	

}
