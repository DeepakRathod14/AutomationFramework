package Learning.Automation.pageobject;

import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void doLogin(String username, String password) {
		System.out.println("Username : "+username);
		System.out.println("Password : "+password);
	}
	
	public void clickOnLoginBtn() {
		System.out.println("CLick on login");
	}
	
	public boolean verifyErrorMsg(String expectedMsg) {
		//String actualErrorMsg = driver.findElement(By.id("dfd")).getText();
		// return (actualErrorMsg.equal(expectedMsg));
		System.out.println("Error msg");
		return true;
	}
	
	public boolean verifyLoginSuccess() {
		//return driver.findElement(By.id("logo")).isDisplay();
		return true;
	}
}
