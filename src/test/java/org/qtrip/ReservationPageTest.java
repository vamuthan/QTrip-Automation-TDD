package org.qtrip;

import baseTest.BaseTest;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qtrip.pages.HomePage;
import org.qtrip.pages.LoginPage;
import org.qtrip.pages.MainMenuPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import propertyReader.PropertyReader;
import utils.DPQTrip;

public class ReservationPageTest extends BaseTest {

    @Test(priority = 0, dataProvider = "sheet2DataProvider")
    public void checkAvailableReservationFunctionalityTest(Object [] data) {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        boolean result = loginPage.performLogin(new PropertyReader().getProperty("userName"),
                new PropertyReader().getProperty("password"));
        MainMenuPage mainMenuPage = PageFactory.initElements(driver, MainMenuPage.class);
        boolean result1 = mainMenuPage.navigateToReservationsPage((String) data[1], (String) data[2], (String) data[3],
                (String) data[4], (String) data[5], (String) data[6]);
        Assert.assertEquals(true, result1);
    }

    @Test(priority = 1, dataProvider= "sheet3DataProvider")
    public void cancelTheReservationFunctionalityTest(Object [] data) {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        boolean result = loginPage.performLogin(new PropertyReader().getProperty("userName"),
                new PropertyReader().getProperty("password"));
        MainMenuPage mainMenuPage = PageFactory.initElements(driver, MainMenuPage.class);
        boolean result1 = mainMenuPage.navigateToReservationsPage((String) data[1], (String) data[2], (String) data[3],
                (String) data[4], (String) data[5], (String) data[6]);
        Assert.assertEquals(true, result1);
    }

    @DataProvider(name = "sheet2DataProvider")
    public Object [][] getDataFromSheet2() {
        return new DPQTrip().getData(1);
    }

    @DataProvider(name = "sheet3DataProvider")
    public Object [][] getDataFromSheet3() {
        return new DPQTrip().getData(2);
    }

}
