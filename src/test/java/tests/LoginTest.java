package tests;

import com.qa.base.BasePage;
import com.qa.pages.LoginPage;
import com.qa.pages.OnBoardingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
@Listeners(com.qa.listeners.TestAllureListeners.class)
public class LoginTest {
    BasePage basePage;
    Properties props;
    LoginPage loginPage;
    WebDriver driver;
    OnBoardingPage onBoardingPage;

    @BeforeMethod
    public void setup() throws IOException {
        basePage = new BasePage();
        props = basePage.initialize_props();
        driver = basePage.initialize_driver();
//        Map<String, Object> prefs = new HashMap<String, Object>();
//
//        prefs.put("profile.default_content_setting_values.notifications", 2);
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs", prefs);
//        driver = new ChromeDriver(options);
        driver.get(props.getProperty("urlShopee"));
        loginPage = new LoginPage(driver);
//        onBoardingPage = new OnBoardingPage(driver);
//        onBoardingPage.OnBoarding();
    }
    @Test(priority = 0, description = "Login in Website")
    public void invalidEmail() {
        loginPage.Login(props.getProperty("invalidEmail"), props.getProperty("password"));
    }

    @Test(priority = 1, description = "Login in Website")
    public void invalidPassword() {
        loginPage.Login(props.getProperty("email"), props.getProperty("invalidPassword"));
    }
    @Test(priority = 2, description = "Login in Website")
    public void SuccessfulLogin() {
        loginPage.Login(props.getProperty("email"), props.getProperty("password"));
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }
}
