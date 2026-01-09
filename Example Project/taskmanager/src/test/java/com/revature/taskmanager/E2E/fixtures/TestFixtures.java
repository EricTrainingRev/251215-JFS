package com.revature.taskmanager.E2E.fixtures;

import com.revature.taskmanager.E2E.poms.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static io.restassured.RestAssured.when;

public class TestFixtures {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static LoginPage loginPage;

    public static void healthCheck() {
        int retries = 10;
        for (int i = 0; i < retries; i++) {
            try {
                when().get("http://localhost:8080/health").then().statusCode(200);
                return; // App is ready
            } catch (Exception e) {
                try { Thread.sleep(1000); } catch (InterruptedException ignored) {}
            }
        }
        throw new RuntimeException("Application did not start in time");
    }

    @Before
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        healthCheck();
    }

    @After
    public static void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
