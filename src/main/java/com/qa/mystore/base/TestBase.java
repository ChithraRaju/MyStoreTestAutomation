package com.qa.mystore.base;


import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

@Listeners({ExtentITestListenerClassAdapter.class})
public class TestBase {

    public static WebDriver driver;
    public static Properties prop;
    public static final String propFileName = "config.properties";

    public TestBase() {
        try {
            prop = new Properties();

            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization() throws Exception {
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    new File("./src/main/resources/chromedriver.exe").getCanonicalPath());

            driver = new ChromeDriver();

        } else if (browserName.equals("FF")) {
            throw new Exception("chrome driver not found");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
