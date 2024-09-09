package org.qtrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qtrip.baseclass.BaseClass;

public class RegisterPage extends BaseClass {

    @FindBy(css = "form > div:nth-child(1) > input")
    protected static WebElement emailIDInputField;

    @FindBy(css = "form > div:nth-child(2) > input")
    protected static WebElement passwordInputField;

    @FindBy(css = "form > div:nth-child(4) > input")
    protected static WebElement reTypePasswordInputField;

    @FindBy(css = "button[type = 'submit']")
    protected static WebElement registerNowBtn;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public boolean createANewUser(String userName, String password) {

        try{
            waitForVisibility(emailIDInputField);
            emailIDInputField.sendKeys(userName);
            pause(1);
            waitForVisibility(passwordInputField);
            passwordInputField.sendKeys(password);
            pause(1);
            waitForVisibility(reTypePasswordInputField);
            reTypePasswordInputField.sendKeys(password);
            pause(1);
            waitForClickability(registerNowBtn);
            registerNowBtn.click();
            pause(1);
            LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
            loginPage.performLogin(userName, password);
            return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
