package com.qa.pages;

import com.qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnBoardingPage extends BasePage {

    @FindBy(className = "_2c__Iu")
    WebElement btnClose;

    public OnBoardingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void OnBoarding() {
        click(btnClose);
    }
}
