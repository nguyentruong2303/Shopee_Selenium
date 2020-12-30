package com.qa.listeners;

import com.qa.base.BasePage;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestAllureListeners implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    @Attachment(value = "Page screenshot",type = "image/html")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    @Attachment(value = "{0}",type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }
    @Attachment(value = "{0}",type = "text/plain")
    public static String attachHtml(String html) {
        return html;
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("I am in onTestStart method" + getTestMethodName(result) + "start");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("I am in onTestSuccess method" + getTestMethodName(result) + "success");
        Object testClass = result.getInstance();
        WebDriver driver = BasePage.getDriver();
        if (driver instanceof WebDriver) {
            System.out.println("Screenshot captured for test case :" + getTestMethodName(result));
            saveScreenshotPNG(driver);
        }
        saveTextLog(getTestMethodName(result) + "passed and screenshot taken");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("I am in onTestFailure method" + getTestMethodName(result) + "failed");
        Object testClass = result.getInstance();
        WebDriver driver = BasePage.getDriver();
        if (driver instanceof WebDriver) {
            System.out.println("Screenshot captured for test case :" + getTestMethodName(result));
            saveScreenshotPNG(driver);
        }
        saveTextLog(getTestMethodName(result) + "failed and screenshot taken");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("I am in onTestSkipped method" + getTestMethodName(result));
        Object testClass = result.getInstance();
        WebDriver driver = BasePage.getDriver();
        if (driver instanceof WebDriver) {
            System.out.println("Screenshot captured for test case :" + getTestMethodName(result));
            saveScreenshotPNG(driver);
        }
        saveTextLog(getTestMethodName(result) + "failed and screenshot taken");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("I am in onTestFailedButWithinSuccessPercentage method" + getTestMethodName(result));
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("I am in onStart method" + context.getName());
        context.setAttribute("WebDriver",BasePage.getDriver());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("I am in onFinish" + context.getName());

    }
}
