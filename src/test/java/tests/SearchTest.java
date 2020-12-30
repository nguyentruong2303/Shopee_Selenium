package tests;

import com.qa.base.BasePage;
import com.qa.pages.SearchPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
@Listeners(com.qa.listeners.TestAllureListeners.class)
public class SearchTest {
    BasePage basePage;
    Properties props;
    SearchPage searchPage;
    WebDriver driver;

    @BeforeMethod
    public void setup() throws IOException {
        basePage = new BasePage();
        props = basePage.initialize_props();
        driver = basePage.initialize_driver();
        driver.get(props.getProperty("urlShopee"));
        searchPage = new SearchPage(driver);
    }

    @Test(priority = 0, description = "Search on Website")
    @Severity(SeverityLevel.BLOCKER)
    @Description(value = "Search on Website")
    public void invalidTxt() {
        searchPage.Search(props.getProperty("invalidTxt"));
    }

    @Test(priority = 1, description = "Search on Website")
    @Severity(SeverityLevel.BLOCKER)
    @Description(value = "Search on Website")
    public void SuccessfulSearch() {
        searchPage.Search(props.getProperty("txt"));
    }
}
