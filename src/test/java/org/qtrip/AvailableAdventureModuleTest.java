package org.qtrip;

import baseTest.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.qtrip.pages.HomePage;
import org.qtrip.pages.MainMenuPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import propertyReader.PropertyReader;
import utils.DPQTrip;


public class AvailableAdventureModuleTest extends BaseTest {

    @Test(priority = 0, dataProvider = "sheet1DataProvider")
    public void checkBookAdventureTest(Object[] data) {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
//        boolean result = homePage.navigateToLoginPage(new PropertyReader().getProperty("userNameLO"),
//                new PropertyReader().getProperty("passwordLO"));
        boolean result = homePage.navigateToLoginPage("tr@io.com", "123123");
        MainMenuPage mainMenuPage = PageFactory.initElements(driver, MainMenuPage.class);
        boolean result1 = mainMenuPage.selectTheCity((String) data[1], (String) data[2], (String) data[3],
                (String) data[4], (String) data[5], (String) data[6]);
        Assert.assertEquals(result1, true);
    }

    @DataProvider(name = "sheet1DataProvider")
    public Object [][] getData() {
        return new DPQTrip().getData(0);
    }

}

