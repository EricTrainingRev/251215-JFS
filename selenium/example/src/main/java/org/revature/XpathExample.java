package org.revature;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathExample {

    public static void main(String[] args) {
        WebDriver driver = null;
        try{
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            driver = new ChromeDriver(options);
//            fullXPath(driver);
            relativeXPath(driver);
        } finally {
            if (driver != null){
                driver.quit();
            }
        }
    }

    /*
        XPath is a way of querying the dom to find an element on your page. It is
        similar in structure to how a file path would be written to locate a directory
        or file in the file system. Similar to how we navigate the DOM for interacting
        with elements in JS/TS, we can navigate the dom structure with our XPath query
        to target one or more elements we want to interact with
     */

    static void fullXPath(WebDriver driver){
        /*
            You can always provide the full node tree path as your XPath query to locate an element. You can think
            of this as being similar to providing an absolute file path in a file system. This type of query is
            supported in most browsers, but the means of performing this query is not standardized in the same way that
            css selector implementation is standardized, so you won't have the same guarantee of behavior/efficiency
            that you can expect with css selectors. Keep this tool in mind as an option, but prefer css selectors
            when you can
         */
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.xpath("/html/body/main/nav[1]/div[1]/a")).click();
        System.out.println(driver.getTitle());
    }

    static void relativeXPath(WebDriver driver){
        /*
            Relative XPath is indicated via two // instead of one. The "relative" nature is in relationship to whatever
            the previous node is, so if you start your query with // then the query is relative to the document itself.
            With the use of functions relative XPath can get you access to nested elements in a much cleaner way than
            using the full XPath will provide. It will also typically be a more stable solution than full XPath, especially
            when you have pages that update dynamically
         */
        driver.get("https://www.wikipedia.org/");
        driver.findElement(By.xpath("//strong[text()='English']")).click();
        System.out.println(driver.getTitle());
    }
}
