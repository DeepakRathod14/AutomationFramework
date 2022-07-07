package Learning.Automation.pageobject;

import java.awt.Button;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.reflect.Reflection;

//1. Custom logic 
//2. PageFactory designed pattern
public class BasePageObject {
	
	protected WebDriver driver;
	private static Map<Class, Object> mapping = new HashMap<Class, Object>();
	private Map<Class, Class> factory = new HashMap<>();
	
	public BasePageObject(WebDriver driver) {
		this.driver=driver;
	}
	
	public void initObjects() {
		mapping.put(TextBoxPage.class, new TextBoxPage(driver));
		mapping.put(ButtonPage.class, new ButtonPage(driver));
		mapping.put(LoginPage.class, new LoginPage(driver));
	}

	
	@SuppressWarnings("unchecked")
	public <T> T initPageFactory(Class clazz) {
		if(clazz.equals(TextBoxPage.class))
		{
			return (T) PageFactory.initElements(driver, TextBoxPage.class);
		}
		else if(clazz.equals(ButtonPage.class))
		{
			return (T) PageFactory.initElements(driver, ButtonPage.class);
		}
		else if(clazz.equals(LoginPage.class))
		{
			return (T) PageFactory.initElements(driver, LoginPage.class);
		}
		else {
			return null;
		}
	}
	
	public static Object getObject(Class clazz) {
		System.out.println(mapping.get(clazz).toString());
		return mapping.getOrDefault(clazz, new NullPointerException());
	}
	
	public void sendKey(By by, String value) {
		highlightElement(by);
		WebElement ele = driver.findElement(by);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
		ele.sendKeys(value);
	}
	
	private void highlightElement(By by) {
		Wait wait = new FluentWait<WebDriver>(driver)
				.pollingEvery(Duration.ofMillis(300))
				.withTimeout(Duration.ofMinutes(1))
				.ignoring(NoSuchElementException.class, TimeoutException.class);
		
		//wait.until();
	}
}
