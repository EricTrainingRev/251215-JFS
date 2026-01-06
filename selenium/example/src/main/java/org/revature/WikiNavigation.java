package org.revature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class WikiNavigation {

    public static void main(String[] args) {
        /*
            When using Selenium to navigate the webs you need to be able to tell the software
            how to find and interact with elements on the web page. To do this you need to
            choose a locator strategy when figuring out what element to interact with on the
            page, which will then determine what your possible actions are
         */
        WebDriver driver = null;
        try {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
//            basicNavigation(driver);
//            findMultipleElements(driver);
            elementDoesNotExist(driver);
        } finally {
            if (driver != null){
                driver.quit();
            }
        }
    }

    static void basicNavigation(WebDriver driver){
            driver.get("https://www.wikipedia.org/");
            /*
                Once you are on the page you want to automate you can use the
                findElement method to tell Selenium to locate an element on the
                page. To provide the information Selenium should use to locate the
                element we use the By class. This object contains the instructions
                Selenium will use to locate the element in the browser
             */
            By idSelector = By.id("js-link-box-en");
            WebElement englishLink = driver.findElement(idSelector);
            /*
                Now that we have access to our english link we can tell Selenium to
                click on the link to perform navigation to the new page
             */
            englishLink.click();
            /*
                Once the button is clicked all that is left to do is validate the
                new page is the one we wanted to go to
             */
            System.out.println(driver.getTitle());
        }

    static void findMultipleElements(WebDriver driver){
        driver.get("https://www.wikipedia.org/");
        /*
            If you need to find a collection of elements you can use the
            findElements (note it is plural) method. This is a safer option for
            searching for elements if you are not sure if the element you want exists
            on the page. findElement() will throw an exception if it can not find an
            element based on the locator information you provide, whereas the
            findElements method will return an empty list if no elements are found
            with your provided locator information

            Something to keep in mind: if using findElements as a safer way to check
            for a singular element you will want to make sure your locator strategy
            is as specific as you can make it, otherwise you run the risk of grabbing
            extra data you need to filter through
         */
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());
    }

    static void elementDoesNotExist(WebDriver driver){
        /*
            If findElement does not target a valid element then Selenium will throw
            a NoSuchElementException, crashing your code unless you handle it
         */
        driver.get("https://www.wikipedia.org/");
        System.out.println(driver.findElement(By.id("does-not-exist")).getText());
    }

}
