package org.qtrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.qtrip.baseclass.BaseClass;

import java.util.List;

public class ReservationsPage extends BaseClass {

    @FindBy(css = "ul > li:nth-child(1)")
    protected WebElement homeBtn;

    @FindBy(css = "ul > li:nth-child(3)")
    protected WebElement logoutBtn;

    @FindBy(css = "tbody > tr > td:nth-child(2)")
    protected List<WebElement> bookingNameContainer;

    @FindBy(css = "tbody > tr > td:nth-child(3)")
    protected List<WebElement> adventureContainer;

    @FindBy(css = "tbody > tr > td:nth-child(4)")
    protected List<WebElement> personCountContainer;

    @FindBy(css = "tbody > tr > td:nth-child(5)")
    protected List<WebElement> dateContainer;

    @FindBy(css = "tbody > tr > td:nth-child(6)")
    protected List<WebElement> priceContainer;

    @FindBy(css = "tbody > tr > td:nth-child(9)")
    protected List<WebElement> cancelReservationBtnContainer;

    public ReservationsPage(WebDriver driver) {
        super(driver);
    }

    public boolean verifyTheReservation(String bookingName, String adventure, String persons, String date,
                                        String price) {
        int currentIndex = runOverTheReservationList(bookingName, adventure, persons, date, price);
        return currentIndex < 0 ? false : true;
    }

    public boolean cancelTheReservation(String bookingName, String adventure, String persons, String date,
                                        String price) {
            int currentIndex = runOverTheReservationList(bookingName, adventure, persons, date, price);
            if(currentIndex < 0) {
                return false;
            }
            else {
                cancelReservationBtnContainer.get(currentIndex).click();
                return true;
            }
    }

    public int runOverTheReservationList(String bookingName, String adventure, String persons, String date,
                                         String price) {
        int currentIndex =  bookingNameContainer.size()-1;
        while (currentIndex >= 0) {
            if(bookingNameContainer.get(currentIndex).getText().equalsIgnoreCase(bookingName) &&
                    adventureContainer.get(currentIndex).getText().equalsIgnoreCase(adventure) &&
                    personCountContainer.get(currentIndex).getText().equalsIgnoreCase(persons) &&
                    dateContainer.get(currentIndex).getText().equalsIgnoreCase(date) &&
                    priceContainer.get(currentIndex).getText().equalsIgnoreCase(price)) {
                return currentIndex;
            }
            currentIndex--;
        }
        return -1;
    }

}
