package Learning.Automation.baseclasses;

import org.testng.Assert;

import Learning.Automation.pageobject.BasePageObject;

public class Assertion extends Assert{

	public static void assertTrue(boolean condition) {
		if(!condition) {
			Assert.assertTrue(condition);
		}
	}
}
