package ru.tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BeforeAfterSetup {
    static WebDriver driver;
    private static String driverPath = "C:\\Users\\Public\\chromedriver.exe";
    private static String website = "https://www.wrike.com/";

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(website);
        System.out.println("Launching chromedriver...");
    }
    @Before
    public void goToWrikeHomePage(){
        driver.get(website);
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
        System.out.println("Testing is complete");
    }
}