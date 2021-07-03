package com.qa.mystore.testcases;

import com.qa.mystore.base.TestBase;
import com.qa.mystore.pages.HomePage;
import com.qa.mystore.pages.SummerDressesPage;
import org.testng.annotations.*;

import static org.testng.Assert.*;


public class HomePageTest extends TestBase {
    private HomePage homePage;
    private SummerDressesPage summerDressesPage;
    private static final String homePageTitle = "My Store";

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void testSetUp() throws Exception {
        initialization();
        homePage = new HomePage();
    }

    @Test(priority=1)
    public void titleTest(){
        assertEquals(homePage.getPageTitle(), homePageTitle);
    }

    @Test(priority=2)
    public void elementPresentTest(){
        assertTrue(homePage.isDressesDisplayed());
    }

    @Test(priority=3)
    public void navigateToSummerDressesPageTest(){
        summerDressesPage = homePage.navigateToSummerDressesPage();
        assertNotNull(summerDressesPage);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}