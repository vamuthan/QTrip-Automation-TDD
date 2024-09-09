package org.qtrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qtrip.baseclass.BaseClass;

public class HomePage extends BaseClass {

    @FindBy(css = "a[class = 'nav-link login']")
    protected WebElement loginHereBtn;

    @FindBy(css = "a[class = 'nav-link login register']")
    protected WebElement registerBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean navigateToRegisterUserPage(String userName, String password) {
        waitForVisibility(registerBtn);
        registerBtn.click();
        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        registerPage.createANewUser(userName, password);
        return true;
    }

    public boolean navigateToLoginPage(String userName, String password) {
        waitForVisibility(loginHereBtn);
        loginHereBtn.click();
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.performLogin(userName, password);
        return true;
    }

}
