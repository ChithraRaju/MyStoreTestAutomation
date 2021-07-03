package com.qa.mystore.pages;

import com.qa.mystore.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath="//div[@id='block_top_menu']/ul/li[a/@title='Dresses']")
    private WebElement dresses;

    @FindBy(xpath = "//div[@id='block_top_menu']/ul/li[a/@title='Dresses']/ul/li/a[@title='Summer Dresses']")
    private WebElement summerDresses;

    //Initializing the Page Objects:
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isDressesDisplayed() {
        return dresses.isDisplayed();
    }

    public SummerDressesPage navigateToSummerDressesPage() {
        Actions action = new Actions(driver);
        action.moveToElement(dresses).build().perform();
        summerDresses.click();

        return new SummerDressesPage();
    }
}
