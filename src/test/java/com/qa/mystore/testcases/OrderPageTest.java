package com.qa.mystore.testcases;

import com.qa.mystore.base.TestBase;
import com.qa.mystore.pages.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class OrderPageTest extends TestBase {

    private OrderPage orderPage;
    private static final String orderPageTitle = "Order - My Store";

    @BeforeMethod
    public void setUp() throws Exception {
        initialization();

        HomePage homePage = new HomePage();
        homePage.navigateToSummerDressesPage();

        SummerDressesPage summerDressesPage = new SummerDressesPage();
        summerDressesPage.navigateToDressDetailsPage();

        DressDetailsPage dressDetailsPage = new DressDetailsPage();
        dressDetailsPage.addToCart();
        orderPage = dressDetailsPage.navigateToOrderSummary();
    }

    @Test(priority=1)
    public void titleTest(){
        assertEquals(orderPage.getPageTitle(), orderPageTitle);
    }

    @Test(priority=2)
    public void orderTest() {
        assertTrue(orderPage.canOrder());
    }

    @Test(priority=3)
    public void navigateToAuthenticationPageTest() {
        AuthenticationPage authenticationPage = orderPage.navigateToAuthenticationPage();
        assertNotNull(authenticationPage);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}


