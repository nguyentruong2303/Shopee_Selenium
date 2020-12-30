package com.qa.base;

import com.qa.utils.TestUtil;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriver driver;
    public Properties props;
    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
    TestUtil util = new TestUtil();
    public WebDriver initialize_driver() {
        System.setProperty("webdriver.chrome.driver","/Users/baemin/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        tdriver.set(driver);
        return getDriver();
    }

    public static synchronized WebDriver getDriver() {
        return tdriver.get();
    }

    public Properties initialize_props() throws IOException {
        props = new Properties();
        FileInputStream ip = new FileInputStream("/Users/baemin/Downloads/Shopee_Selenium/"
        +"src/main/java/com/qa/config/config.properties");
        props.load(ip);
        return props;
    }

    public String getScreenshot() throws IOException {
        File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshot" + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        FileUtils.copyFile(src,destination);
        return path;
    }
    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(getDriver(),util.WAIT);
        wait.until(ExpectedConditions.visibilityOf(e));
    }
    public void clear(WebElement e) {
        waitForVisibility(e);
        e.clear();
    }
    public void click(WebElement e) {
        waitForVisibility(e);
        e.click();
    }
    public void sendKey(WebElement e, String txt) {
        waitForVisibility(e);
        e.sendKeys(txt);
    }
    public void scrollToElement(WebElement e) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }
    public void getTitle(WebElement e) {
        waitForVisibility(e);
        e.getText();
    }

}
