package org.revature.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.revature.steps.SeleniumTestResources.driver;
import static org.revature.steps.SeleniumTestResources.examplePage;

public class AlertSteps {

    @Given("The example page is open")
    public void the_example_page_is_open() {
        examplePage.openExamplePage();
    }
    @When("The user clicks the button to make a popup appear")
    public void the_user_clicks_the_button_to_make_a_popup_appear() {
        examplePage.clickCreateAlertButton();
    }
    @Then("Selenium can interact with the popup")
    public void selenium_can_interact_with_the_popup() {
        String alertText = examplePage.getAlertText();
        System.out.println(alertText);
    }
    @Then("Selenium can close the alert when done interacting with it")
    public void selenium_can_close_the_alert_when_done_interacting_with_it() {
        examplePage.closeAlert();
        // if the alert does not close the code below will cause an exception to be thrown
        String text = driver.findElement(By.tagName("button")).getText();
        System.out.println(text);
    }
}
