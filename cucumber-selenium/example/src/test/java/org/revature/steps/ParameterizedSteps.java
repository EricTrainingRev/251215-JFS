package org.revature.steps;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.revature.steps.SeleniumTestResources.driver;
import static org.revature.steps.SeleniumTestResources.wikiHome;

public class ParameterizedSteps {

    @When("The user clicks the {string} link")
    public void the_user_clicks_the_link(String language) {
        wikiHome.clickLanguageLink(language);
    }
    @Then("The user should be sent to a page with the title {string}")
    public void the_user_should_be_sent_to_the_homepage_with_the_title(String title) {
        /*
            Anytime you need to wait for a condition to NOT be true you can use the ExpectedConditions not method, which
            acts like the not operator in a logical check
         */
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.not(ExpectedConditions.titleIs("Wikipedia")));
        Assertions.assertEquals(title, driver.getTitle());
    }

}
