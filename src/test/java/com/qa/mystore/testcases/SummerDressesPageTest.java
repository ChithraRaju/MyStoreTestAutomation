package com.qa.mystore.testcases;

import com.qa.mystore.base.TestBase;
import com.qa.mystore.pages.DressDetailsPage;
import com.qa.mystore.pages.HomePage;
import com.qa.mystore.pages.SummerDressesPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SummerDressesPageTest extends TestBase {

    private SummerDressesPage summerDressesPage;
    private static final String summerDressesPageTitle = "Summer Dresses - My Store";

    public SummerDressesPageTest() {
        super();
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        initialization();
        HomePage homePage = new HomePage();
        homePage.navigateToSummerDressesPage();
        summerDressesPage = new SummerDressesPage();
    }

    @Test(priority=1)
    public void titleTest(){
        assertEquals(summerDressesPage.getPageTitle(), summerDressesPageTitle);
    }

    @Test(priority=2)
    public void addDressToCartTest() {
        assertTrue(summerDressesPage.isSummerDressPresent());
        DressDetailsPage dressDetailsPage = summerDressesPage.navigateToDressDetailsPage();
        assertNotNull(dressDetailsPage);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
