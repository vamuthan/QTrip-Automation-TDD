package org.qtrip.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qtrip.baseclass.BaseClass;

import java.util.List;

public class AdventureCataloguePage extends BaseClass {

    @FindBy(css = "select[id='duration-select']")
    protected WebElement durationDropDown;

    @FindBy(css = "select[id = 'duration-select'] > option")
    protected List<WebElement> durationContainer;

    @FindBy(css = "select[id = 'category-select']")
    protected WebElement categoryDropDown;

    @FindBy(css = "select[id = 'category-select'] > option")
    protected List<WebElement> categoryContainer;

    @FindBy(css = "div[id='data'] > div")
    protected WebElement adventureCard;

    public AdventureCataloguePage(WebDriver driver) {
        super(driver);
    }

    public boolean applyFilters(String filterByDuration, String category, String name, String date,
                                String personCount) {
        waitForClickability(durationDropDown);
        durationDropDown.click();
        for(WebElement currentElement : durationContainer) {
            if(currentElement.getText().equalsIgnoreCase(filterByDuration)) {
                waitForVisibility(currentElement);
                currentElement.click();
            }
        }
        waitForClickability(categoryDropDown);
        categoryDropDown.click();
        for(WebElement currentElement : categoryContainer) {
            if(currentElement.getText().equalsIgnoreCase(category)) {
                waitForVisibility(currentElement);
                currentElement.click();
            }
        }
        waitForClickability(adventureCard);
        adventureCard.click();
        AdventureSummaryPage adventureSummaryPage = PageFactory.initElements(driver, AdventureSummaryPage.class);
        return adventureSummaryPage.checkoutTheService(name, date, personCount);
    }
}
