package com.qa.pages;

import com.qa.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(className = "_2c__Iu")
    WebElement btnClose;

    @FindBy(xpath = "//a[contains(text(),'Đăng nhập')]")
    WebElement btnStartLogin;

    @FindBy(xpath = "//body/div[@id='main']/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[1]/input[1]")
    WebElement emailTxt;

    @FindBy(xpath = "//body/div[@id='main']/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[3]/div[1]/input[1]")
    WebElement passwordTxt;

    @FindBy(xpath = "//button[contains(text(),'Đăng nhập')]")
    WebElement btnLogin;

    @FindBy(xpath = "//body/div[@id='main']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/div[1]/div[1]/div[1]/div[2]")
    WebElement titleLogin;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void Login(String email, String password) {
        click(btnClose);
        click(btnStartLogin);
        sendKey(emailTxt,email);
        sendKey(passwordTxt,password);
        click(btnLogin);
        getTitle(titleLogin);
    }
}
