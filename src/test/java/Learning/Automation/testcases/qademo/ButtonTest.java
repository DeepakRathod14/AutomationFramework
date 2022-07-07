package Learning.Automation.testcases.qademo;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Learning.Automation.baseclasses.BaseTestClass;
import Learning.Automation.listeners.RetryClass;
import Learning.Automation.pageobject.BasePageObject;
import Learning.Automation.pageobject.ButtonPage;
import Learning.Automation.pageobject.LoginPage;
import Learning.Automation.pageobject.TextBoxPage;

@Listeners
public class ButtonTest extends BaseTestClass{
	int count=0;
	
	@Test(groups = {"System"})
	public void positiveScenario() {
		TextBoxPage textBox = (TextBoxPage) BasePageObject.getObject(TextBoxPage.class);
		textBox.addFirstName("Automation");
		textBox.addEmail("automation@qa.com");
		textBox.addCurrentAddress("Ahmedabad");
		textBox.addPermanentAddress("India");
		textBox.submit();
		boolean isVerify = textBox.verifySubmitedData("Automation", "automation@qa.com", "Ahmedabad", "India");
		Assert.assertTrue(isVerify);
		System.out.println("Positive scenario - ButtonTest");
	}
	
	@Test(groups = {"System","Regression","Smoke"}, retryAnalyzer = RetryClass.class)
	public void nagativeScenario() {
		Boolean b = new Random().nextBoolean();
		System.out.println("Nagative Scenario  - ButtonTest : 	"+b);
		Assert.assertTrue(false);
	}
	
	@Test(groups = {"System","Regression","Smoke"})
	public void loginScenario() {
		System.out.println("Login scenario -  - ButtonTest");
	}
	
	@Test(groups = {"System","Regression"})
	public void invalidLogin() {
		System.out.println("Invalid login case -  - ButtonTest");
	}
	
}
