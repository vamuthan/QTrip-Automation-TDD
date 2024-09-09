package org.qtrip.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qtrip.baseclass.BaseClass;

import java.util.List;
import java.util.Set;

public class MainMenuPage extends BaseClass {

    @FindBy(css = "div[class = 'nav-link login register']")
    protected WebElement logoutBtn;

    @FindBy(css = "div[id = 'data'] > div > a > div > div h5")
    protected List<WebElement> cityContainer;

    @FindBy(css = "ul:nth-child(1) > li:nth-child(2)")
    protected WebElement reservationBtn;

    public MainMenuPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyLoginOfTheUser() {
        try{
            waitForVisibility(logoutBtn);
            return true;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean selectTheCity(String city, String duration, String category, String name, String date,
                                 String personCount) {
        for(WebElement currentElement : cityContainer) {
            if(currentElement.getText().equalsIgnoreCase(city)) {
                waitForClickability(currentElement);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);", currentElement);
                currentElement.click();
                AdventureCataloguePage adventureCataloguePage = PageFactory.initElements(driver,
                        AdventureCataloguePage.class);
                return adventureCataloguePage.applyFilters(duration, category, name, date, personCount);
            }
        }
        return false;
    }

    public boolean navigateToReservationsPage(String bookingName, String adventure, String person, String date,
                                              String price, String command) {
        waitForClickability(reservationBtn);
        reservationBtn.click();
        ReservationsPage reseravtionsPage = PageFactory.initElements(driver, ReservationsPage.class);
        if(command.equalsIgnoreCase("cancel")) {
            return reseravtionsPage.cancelTheReservation(bookingName, adventure, person,date, price);
        }
        else {
            return reseravtionsPage.verifyTheReservation(bookingName, adventure, person, date, price);
        }
    }

}
