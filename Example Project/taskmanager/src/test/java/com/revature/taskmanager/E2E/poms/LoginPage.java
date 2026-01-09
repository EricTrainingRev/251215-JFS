package com.revature.taskmanager.E2E.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPOM{

    private final String URL = "http://localhost:4200/admin";

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(tagName = "button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage(){
        driver.get(URL);
    }

    public void enterCredentials(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }

    public void attemptLogin(){
        loginButton.click();
    }

}
