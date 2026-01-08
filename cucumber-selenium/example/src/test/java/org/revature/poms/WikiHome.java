package org.revature.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
    When performing web automation it is worthwhile to create Page Object Models (POMs)
    to represent your web pages in your code. These POMs provide a central location to
    facilitate locating elements on a web page and performing actions on those pages.

    Selenium provides a tool called the PageFactory that can help us automate much of the
    locating of elements on web pages, and it is a particularly useful tool that fits
    neatly within the POM design pattern
 */
public class WikiHome {

    private final String URL = "https://www.wikipedia.org/";

    private WebDriver driver;

    /*
        The FindBy annotation provides the PageFactory with the locator strategy and
        value for the locator strategy to use when trying to locate the "englishLink"
        web element. Any time our code tries to interact with the englishLink web element
        the PageFactory will create a brand new WebElement object that represents the
        element and use that new instance for whatever action we try to perform
     */
    @FindBy(id = "js-link-box-en")
    private WebElement englishLink;

    public WikiHome(WebDriver driver){
        this.driver = driver;
        /*
            The PageFactory initElements method requires two arguments: a driver to actually
            handle element initialization, and the object that has web element fields that
            need to be managed by the PageFactory. For this pom we pass the "this" keyword
            to tell Selenium "manage the WebElement initialization for the object being
            created"
         */
        PageFactory.initElements(driver, this);
    }

    public void openMainWikipediaPage(){
        driver.get(URL);
    }

    public void clickEnglishLink(){
        englishLink.click();
    }

    public void clickLanguageLink(String language){
        driver.findElement(By.partialLinkText(language)).click();
    }

}
