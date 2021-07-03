package com.qa.mystore.pages;

import com.qa.mystore.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DressDetailsPage extends TestBase {

    @FindBy(xpath="//button[span/text()= 'Add to cart']")
    private  WebElement addToCartButton;

    @FindBy(xpath="//div[@class='clearfix']//h2[i]")
    private WebElement addToCartStatusHeader;

    @FindBy(xpath="//div[@class='clearfix']//a[@title='Proceed to checkout']")
    private WebElement proceedToCheckoutButton;

    public DressDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean canAddToCart() {
        return addToCartButton.isEnabled();
    }

    public WebElement addToCart() {
        addToCartButton.click();
        return addToCartStatusHeader;
    }

    public OrderPage navigateToOrderSummary() {
        proceedToCheckoutButton.click();
        return new OrderPage();
    }
}
