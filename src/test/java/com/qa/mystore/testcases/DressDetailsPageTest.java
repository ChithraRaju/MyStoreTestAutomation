package com.qa.mystore.testcases;

import com.qa.mystore.base.TestBase;
import com.qa.mystore.pages.DressDetailsPage;
import com.qa.mystore.pages.HomePage;
import com.qa.mystore.pages.OrderPage;
import com.qa.mystore.pages.SummerDressesPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DressDetailsPageTest extends TestBase {

    private DressDetailsPage dressDetailsPage;
    private static final String addToCartSuccessMessage = "Product successfully added to your shopping cart";

    public DressDetailsPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws Exception {
        initialization();
        HomePage homePage = new HomePage();
        homePage.navigateToSummerDressesPage();
        SummerDressesPage summerDressesPage = new SummerDressesPage();
        summerDressesPage.navigateToDressDetailsPage();
        dressDetailsPage = new DressDetailsPage();
    }

    @Test(priority=1)
    public void titleTest(){
        assertNotNull(dressDetailsPage.getPageTitle());
    }

    @Test(priority=2)
    public void addToCartTest() throws InterruptedException {
        assertTrue(dressDetailsPage.canAddToCart());
        WebElement addToCartStatusHeader = dressDetailsPage.addToCart();

        Thread.sleep(3000);
        assertEquals(addToCartStatusHeader.getText(), addToCartSuccessMessage);
    }

    @Test(priority=3)
    public void navigateToOrderSummaryTest() {
        dressDetailsPage.addToCart();
        OrderPage orderPage = dressDetailsPage.navigateToOrderSummary();
        assertNotNull(orderPage);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
