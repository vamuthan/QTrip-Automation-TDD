package org.qtrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qtrip.baseclass.BaseClass;

public class LoginPage extends BaseClass {

    @FindBy(css = "form > div:nth-child(1) > input")
    protected WebElement emailIdInputField;

    @FindBy(css = "form > div:nth-child(2) > input")
    protected WebElement passwordInputField;

    @FindBy(css = "form > div:nth-child(3) > button")
    protected WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean performLogin(String userName, String password) {
        try {
            waitForVisibility(emailIdInputField);
            emailIdInputField.sendKeys(userName);
            pause(1);
            waitForVisibility(passwordInputField);
            passwordInputField.sendKeys(password);
            pause(1);
            waitForClickability(loginBtn);
            loginBtn.click();
            pause(1);
            MainMenuPage mainMenuPage = PageFactory.initElements(driver, MainMenuPage.class);
            mainMenuPage.verifyLoginOfTheUser();
            return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
