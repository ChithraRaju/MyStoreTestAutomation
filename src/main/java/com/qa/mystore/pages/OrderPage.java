package com.qa.mystore.pages;

import com.qa.mystore.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends TestBase {

    @FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium' and @title='Proceed to checkout']")
    WebElement orderCheckoutButton;

    public OrderPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean canOrder() {
        return orderCheckoutButton.isEnabled();
    }

    public AuthenticationPage navigateToAuthenticationPage(){
        orderCheckoutButton.click();
        return new AuthenticationPage();
    }
}
