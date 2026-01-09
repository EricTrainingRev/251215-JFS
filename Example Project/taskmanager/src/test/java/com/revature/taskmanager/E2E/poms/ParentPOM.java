package com.revature.taskmanager.E2E.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class ParentPOM {

    protected WebDriver driver;

    public ParentPOM(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
