package com.qa.pages;

import com.qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BasePage {

    @FindBy(className = "customized-overlay-image")
    WebElement slProduct;

    @FindBy(className = "btn-tinted")
    WebElement btnAddToCart;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void Order(){
        click(slProduct);
        click(btnAddToCart);
    }
}
