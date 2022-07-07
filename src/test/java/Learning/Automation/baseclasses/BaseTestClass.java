package Learning.Automation.baseclasses;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Learning.Automation.pageobject.BasePageObject;
import Learning.Automation.pageobject.TextBoxPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestClass {
	
	protected BasePageObject result;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	@BeforeTest(groups = {"System","Regression","Smoke"})
	@Parameters({"Browser","url"})
	public void loadBrowser(String browser, String url) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}
		else
		{
			System.out.println("NoSupported Browser...");
			System.exit(0);
		}
		tlDriver.get().manage().window().maximize();
		result = new BasePageObject(tlDriver.get());
		result.initObjects();
		tlDriver.get().get(url);
	}
	
	
	@AfterTest(groups = {"System","Regression","Smoke"})
	public void closeBrowser() {
		tlDriver.get().close();
	}
	
}
