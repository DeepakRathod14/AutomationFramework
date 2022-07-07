package Learning.Automation.testcases.qademo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Learning.Automation.baseclasses.BaseTestClass;
import Learning.Automation.listeners.RetryClass;
import Learning.Automation.pageobject.BasePageObject;
import Learning.Automation.pageobject.ButtonPage;
import Learning.Automation.pageobject.LoginPage;
import Learning.Automation.pageobject.TextBoxPage;

public class CheckBoxTest extends BaseTestClass{
	
	@Test(groups = {"System"}, retryAnalyzer = RetryClass.class)
	public void positiveScenario() {
		TextBoxPage textBox = (TextBoxPage) BasePageObject.getObject(TextBoxPage.class);
		textBox.addFirstName("Automation");
		textBox.addEmail("automation@qa.com");
		textBox.addCurrentAddress("Ahmedabad");
		textBox.addPermanentAddress("India");
		textBox.submit();
		boolean isVerify = textBox.verifySubmitedData("Automation", "automation@qa.com", "Ahmedabad", "India");
		Assert.assertTrue(isVerify);
		System.out.println("Positive scenario - CheckBoxTest");
	}
	
	@Test(groups = {"System","Regression","Smoke"})
	public void nagativeScenario() {
		System.out.println("Nagative scenario");
	}
	
	@Test(groups = {"System","Regression"})
	public void loginScenario() {
		System.out.println("Login case - CheckBoxTest");
	}
	
	@Test(groups = {"System","Regression"})
	public void invalidLogin() {
		System.out.println("Invalid login case - CheckBoxTest");
	}
	
}
