package org.revature.poms;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExamplePage {

    /*
        On Windows you can put the absolute file path alone, on Mac you need to append the "file://" protocol statement.
        If you run into issues with the URL being recognized try adding the "file://" protocol to the start of the
        path
     */
    private final String URL = "C:\\Users\\EricSuminski\\Desktop\\251215-JFS\\cucumber-selenium\\example\\src\\test\\resources\\example-page.html";

    private WebDriver driver;

    @FindBy(tagName = "button")
    private WebElement button;

    @FindBy(id = "exampleSelect")
    private WebElement select;

    public ExamplePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openExamplePage(){
        driver.get(URL);
    }

    public void clickCreateAlertButton(){
        button.click();
    }

    public String getAlertText(){
        /*
            When you need to interact with a pop up you have to tell the driver to
            switch over to the pop up
         */
        Alert alert = driver.switchTo().alert();
        // Once we have access to the alert we can perform our action on it
        return alert.getText();
    }

    /*
        If you ever need to manage alerts I recommend performing all interactions and then closing the alert when done
        within a single step if possible, this is just here to show off that you can "switch" back to the alert if you
        lose access to an Alert object made previously
     */
    public void closeAlert(){
        driver.switchTo().alert().accept();
    }

    public WebElement getSelect(){
        return select;
    }

}
