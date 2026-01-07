package org.revature.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.revature.poms.WikiHome;

import java.time.Duration;

public class SeleniumTestResources {

    public static WebDriver driver;

    public static WikiHome wikiHome;

    @Before
    public static void setup(){
        System.out.println("Starting Selenium Setup");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wikiHome = new WikiHome(driver);
        System.out.println("Selenium Setup finished");
    }

    @After
    public static void tearDown(){
        System.out.println("Starting Selenium teardown");
        if(driver != null){
            driver.quit();
        }
        System.out.println("Selenium teardown finished");
    }

}
