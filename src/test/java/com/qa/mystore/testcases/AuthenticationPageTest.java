package com.qa.mystore.testcases;

import com.qa.mystore.base.TestBase;
import com.qa.mystore.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class AuthenticationPageTest extends TestBase {

    private AuthenticationPage authenticationPage;
    private static final String authenticationPageTitle = "Login - My Store";

    public AuthenticationPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        initialization();

        HomePage homePage = new HomePage();
        homePage.navigateToSummerDressesPage();

        SummerDressesPage summerDressesPage = new SummerDressesPage();
        summerDressesPage.navigateToDressDetailsPage();

        DressDetailsPage dressDetailsPage = new DressDetailsPage();
        dressDetailsPage.addToCart();
        OrderPage orderPage = dressDetailsPage.navigateToOrderSummary();

        authenticationPage = orderPage.navigateToAuthenticationPage();
    }

    @Test(priority=1)
    public void titleTest(){
        assertEquals(authenticationPage.getPageTitle(), authenticationPageTitle);
    }


    @AfterMethod
    public void tearDown() {
    driver.quit();
}
}


