package org.qtrip;

import baseTest.BaseTest;
import jdk.jfr.Description;
import org.openqa.selenium.support.PageFactory;
import org.qtrip.pages.HomePage;
import org.qtrip.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DataUtility;

public class RegisterUserPageTest extends BaseTest {

    @Test(priority = 0)
    @Description("create new user and verify that new users are able to login")
    public void checkCreateUserFunctionality(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        boolean result = homePage.navigateToRegisterUserPage(new DataUtility().generateFakeEmailId(),
                new DataUtility().generateFakePassword());
        Assert.assertEquals(result, true);
    }

}
