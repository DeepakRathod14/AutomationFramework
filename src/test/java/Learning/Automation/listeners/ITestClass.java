package Learning.Automation.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import Learning.Automation.baseclasses.BaseTestClass;
import Learning.Automation.pageobject.BasePageObject;

public class ITestClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("OnTestStart [Result-Name] : "+result.getName());
		System.out.println("OnTestStart [Result-testName()] : "+result.getTestName());
		System.out.println("OnTestStart [Result-id()] : "+result.id());
		System.out.println("OnTestStart [Result-getInstanceName()] : "+result.getInstanceName());
		
		System.out.println("StartTime : "+result.getStartMillis());
		System.out.println("GetAttribute From @Test : "+result.getAttributeNames());
		System.out.println("Result.isNotRunning : "+result.isNotRunning());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		String path = System.getProperty("user.dir")+"/output/";
		new File(path).mkdir();
		TakesScreenshot scrShot =((TakesScreenshot)BaseTestClass.tlDriver.get());
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(path+result.getName()+"_"+System.currentTimeMillis()+".png");
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 Reporter.log("<a href="+DestFile+"><br>  <img src='"+DestFile+"' height='100' width='100' /><br></a>");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage");
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		onTestFailure(result);
	}

	public void onStart(ITestContext context) {
		System.out.println("onStart : "+context.getOutputDirectory());
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
	}
}
