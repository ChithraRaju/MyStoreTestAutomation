package com.qa.mystore.pages;

import com.qa.mystore.base.TestBase;
import org.openqa.selenium.support.PageFactory;

public class AuthenticationPage extends TestBase {

    public AuthenticationPage() {
        PageFactory.initElements(driver, this);
    }
}
