package org.revature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
    Selenium provides options for instructing the software on how to handle data not
    being ready/available/whatever when Selenium expects it. There are all kinds of reasons
    why data might not be readily available when Selenium requests it. A page could take a
    long time to load, or your latency may be poor, or an action might just take a long time
    to complete. Implicit waits and Explicit waits are how we can navigate these situations
    without Selenium throwing exceptions that crash our application
 */
public class Waits {

    public static void main(String[] args) {
        WebDriver driver = null;
        try{
            driver = new ChromeDriver();
            /*
                Drivers have an implicit wait configuration that lets us tell Selenium how long to wait for an element
                to be interactable before throwing an exception. Setting this configuration helps to prevent your automation
                from being flakey (sometimes works, sometimes fails). The code below tells Selenium to wait up to 2 seconds
                before throwing an ElementNotFound Exception anytime we try to find elements on the page
             */
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            driver.get("https://www.wikipedia.org/");
            driver.findElement(By.id("js-link-box-en")).click();
            /*
                Anytime you need Selenium to wait for some condition that is not the element being located you can use
                a WebDriverWait object to provide Selenium with the instructions for how long to wait and what it is
                waiting for.

                If you know that you have a wait time you will constantly need to use you can always save your
                WebDriverWait object and reuse it as needed.

                Selenium provides the ExpectedConditions class which provides a large collection of common conditions
                and/or states that we will want to tell Selenium to wait for before continuing execution. Check the
                methods provided by ExpectedConditions before trying to implement any sort of custom wait
             */
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.titleIs("Wikipedia, the free encyclopedia"));
            System.out.println(driver.getTitle());
        } finally {
            if (driver != null){
                driver.quit();
            }
        }
    }

}
