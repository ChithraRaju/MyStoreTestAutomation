package com.qa.mystore.pages;

import com.qa.mystore.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SummerDressesPage extends TestBase {

    @FindBy(xpath = "//ul[@class='product_list grid row']//div[@class='product-container']//a[@title='View']")
    private List<WebElement> moreInfoAnchorElements;

    @FindBy(xpath = "//ul[@class='product_list grid row']//div[@class='product-container']")
    private List<WebElement> productContainerElements;

    public SummerDressesPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isSummerDressPresent() {
        return productContainerElements.size() != 0;
    }

    public DressDetailsPage navigateToDressDetailsPage() {
        Actions action = new Actions(driver);
        action.moveToElement(productContainerElements.get(0)).build().perform();

        moreInfoAnchorElements.get(0).click();
        return new DressDetailsPage();
    }
}
