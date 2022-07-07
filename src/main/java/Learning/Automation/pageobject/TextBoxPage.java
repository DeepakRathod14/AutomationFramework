package Learning.Automation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TextBoxPage extends BasePageObject {

	@FindBy(id = "foobar") 
	@CacheLookup
	WebElement foo; //StelElementReferance Exception
	
	public TextBoxPage(WebDriver driver) {
		super(driver);
	}

	public void addFirstName(String firstName) {
		sendKey(By.id("userName"), firstName);
		foo.click();
	}

	public void addEmail(String email) {
		sendKey(By.id("userEmail"), email);
	}

	public void addCurrentAddress(String cAddress) {
		sendKey(By.id("currentAddress"), cAddress);
	}

	public void addPermanentAddress(String pAddress) {
		sendKey(By.id("permanentAddress"), pAddress);
	}

	public void submit() {
		scroll(450, 0);
		driver.findElement(By.id("submit")).click();
	}

	public void scroll(int vertical, int horizontal) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + horizontal + "," + vertical + ")", "");
	}

	public boolean verifySubmitedData(String fName, String email, String cAdd, String pAdd) {
		System.out.println("Name : "+driver.findElement(By.id("name")).getText());
		System.out.println("Email : "+driver.findElement(By.id("email")).getText());
		System.out.println("CADD : 	"+driver.findElement(By.id("currentAddress")).getAttribute("value"));
		System.out.println("PADD : "+driver.findElement(By.id("permanentAddress")).getAttribute("value"));
		
		System.out.println("Name : "+driver.findElement(By.id("name")).getText().contains(fName));
		System.out.println("Email : "+driver.findElement(By.id("email")).getText().contains(email));
		System.out.println("CAdd : "+driver.findElement(By.id("currentAddress")).getAttribute("value").contains(cAdd));
		System.out.println("PAdd : "+driver.findElement(By.id("permanentAddress")).getAttribute("value").contains(pAdd));
		
		return (driver.findElement(By.id("name")).getText().contains(fName)
				&& driver.findElement(By.id("email")).getText().contains(email)
				&& driver.findElement(By.id("currentAddress")).getAttribute("value").contains(cAdd)
				&& driver.findElement(By.id("permanentAddress")).getAttribute("value").contains(pAdd));		
	}
}
