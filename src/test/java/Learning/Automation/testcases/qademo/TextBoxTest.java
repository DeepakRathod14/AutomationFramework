package Learning.Automation.testcases.qademo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Learning.Automation.baseclasses.Assertion;
import Learning.Automation.baseclasses.BaseTestClass;
import Learning.Automation.pageobject.BasePageObject;
import Learning.Automation.pageobject.ButtonPage;
import Learning.Automation.pageobject.LoginPage;
import Learning.Automation.pageobject.TextBoxPage;
import Learning.Automation.utilities.Groups;

public class TextBoxTest extends BaseTestClass{
	
	@Test(groups = {Groups.SYSTEM})
	public void positiveScenario() {
		TextBoxPage textBox = (TextBoxPage) BasePageObject.getObject(TextBoxPage.class);
		textBox.addFirstName("Automation");
		textBox.addEmail("automation@qa.com");
		textBox.addCurrentAddress("Ahmedabad");
		textBox.addPermanentAddress("India");
		textBox.submit();
		boolean isVerify = textBox.verifySubmitedData("Automation", "automation@qa.com", "Ahmedabad", "India");
		Assertion.assertTrue(isVerify);
		//Assert.assertTrue(isVerify);
		System.out.println("Positive scenario - TextBoxTest");
	}
	
	@Test(groups = {Groups.SYSTEM,Groups.REGRESSION,Groups.SMOKE})
	public void nagativeScenario() {
		System.out.println("Nagative scenario -  - TextBoxTest");
	}
	
	@Test(groups = {Groups.SYSTEM,Groups.REGRESSION})
	public void loginScenario() {
		System.out.println("Login case  - TextBoxTest");
	}
	
	@Test(groups = {Groups.SYSTEM,Groups.REGRESSION})
	public void invalidLogin() {
		System.out.println("Invalid login case  - TextBoxTest");
	}
	
}
