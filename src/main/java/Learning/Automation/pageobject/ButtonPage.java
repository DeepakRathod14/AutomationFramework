package Learning.Automation.pageobject;

import org.openqa.selenium.WebDriver;

public class ButtonPage extends BasePageObject{

	public ButtonPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnBtn() {
		System.out.println("Click on button");
	}
}
