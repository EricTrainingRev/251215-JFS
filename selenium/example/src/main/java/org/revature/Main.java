package org.revature;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {
    public static void main(String[] args) {
//        simpleExample();
//        ensureDriverQuits();
        browserOptions();
    }

    public static void simpleExample(){
                /*
            Selenium WebDriver provides us with the capability of automating the
            browser. This automation capability is not limited to testing, but it is
            one of the more common use-cases for Selenium Webdriver.

            With version 4 of Selenium you can simply instantiate your WebDriver and
            get started with your automation. If using version 3 or lower of Selenium,
            you must first point your code to the location of the web driver you want
            to use. Replace chrome with your driver of choice

            System.setProperty("webdriver.chrome.driver", "path/to/driver/software")
         */

        // in Selenium 4 you can just initialize the driver
        WebDriver driver = new ChromeDriver();

        /*
            the "get" method is how you tell Selenium to open a web page. Think of it
            as entering a value into the browser bar and hitting enter
         */
        driver.get("https://www.wikipedia.org/");

        System.out.println(driver.getTitle());
    }

    public static void ensureDriverQuits(){
        WebDriver driver = null;
        try {
            driver = new ChromeDriver();
            driver.get("https://www.wikipedia.org/");
            System.out.println(driver.getTitle());
        } finally {
            if (driver != null){
                /*
                    the WebDriver has two options for closing windows: close() and quit().
                    - close() -> this will close whatever window is currently open
                    - quit() -> this will close all windows and shut down the driver

                    prefer to use quit() over close(), unless specifically closing just
                    a single window
                 */
                driver.quit();
            }
        }
    }

    public static void browserOptions(){
        WebDriver driver = null;
        try{
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
            driver.get("https://www.wikipedia.org/");
            System.out.println(driver.getTitle());
        } finally {
            if(driver != null){
                driver.quit();
            }
        }
    }
}