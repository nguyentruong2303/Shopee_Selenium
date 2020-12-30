package com.qa.pages;

import com.qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {

    @FindBy(className = "_2c__Iu")
    WebElement btnClose;

    @FindBy(className = "shopee-searchbar-input__input")
    WebElement searchTxt;

    @FindBy(className = "btn-solid-primary")
    WebElement btnSearch;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Search(String txt) {
        click(btnClose);
//        click(searchTxt);
        sendKey(searchTxt,txt);
        click(btnSearch);
    }

}
