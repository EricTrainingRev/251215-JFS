package org.revature.steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.revature.steps.SeleniumTestResources.driver;

public class Integration {
    @Then("We can access the driver from within other WebElements")
    public void we_can_access_the_driver_from_within_other_web_elements() {
        /*
            Once you have found an element, if you need to further search for an element
            you an do so within the previously discovered element. You use the same methods
            like you were using a driver resource, but instead of searching the entire
            document for the element the driver will only search inside the element
            that is making the findElement/s method call
         */
        // first we find a container
        WebElement element = driver.findElement(By.id("container"));
        // then we target the element we actually want within the container
        WebElement p = element.findElement(By.tagName("p"));
        System.out.println(p.getText());

    }
}
