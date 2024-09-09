package org.qtrip.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.qtrip.baseclass.BaseClass;

public class AdventureSummaryPage extends BaseClass {

    @FindBy(css = "input:nth-child(2)")
    protected WebElement inputTextField;

    @FindBy(css = "input:nth-child(5)")
    protected WebElement datePicker;

    @FindBy(css = "input:nth-child(1)")
    protected WebElement personCountInputTextField;

    @FindBy(css = "button[type='submit']")
    protected WebElement reserveBtn;

    public AdventureSummaryPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkoutTheService(String name, String date, String personCount) {
        try {
            waitForVisibility(inputTextField);
            inputTextField.sendKeys(name);
            waitForVisibility(datePicker);
            datePicker.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            datePicker.sendKeys(Keys.DELETE);
            datePicker.sendKeys(date);
            waitForVisibility(personCountInputTextField);
            personCountInputTextField.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            personCountInputTextField.sendKeys(Keys.DELETE);
            personCountInputTextField.sendKeys(personCount);
            waitForClickability(reserveBtn);
            reserveBtn.click();
            return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
