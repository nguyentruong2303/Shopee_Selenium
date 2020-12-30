package tests;

import com.qa.base.BasePage;
import com.qa.pages.LoginPage;
import com.qa.pages.OrderPage;
import com.qa.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
@Listeners(com.qa.listeners.TestAllureListeners.class)
public class OrderTest {
    BasePage basePage;
    Properties props;
    LoginPage loginPage;
    SearchPage searchPage;
    WebDriver driver;
    OrderPage orderPage;

    @BeforeMethod
    public void setup() throws IOException {
        basePage = new BasePage();
        props = basePage.initialize_props();
        driver = basePage.initialize_driver();
        driver.get(props.getProperty("urlShopee"));
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
        orderPage = new OrderPage(driver);
        loginPage.Login(props.getProperty("email"), props.getProperty("password"));
        searchPage.Search(props.getProperty("txt"));
    }

    @Test(priority = 0, description = "Order on Website")
    public void OrderSuccess() {
        orderPage.Order();
    }



}
