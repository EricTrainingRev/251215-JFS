package org.revature.steps;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static org.revature.steps.SeleniumTestResources.driver;
import static org.revature.steps.SeleniumTestResources.wikiHome;

public class ActionsExample {
    @Then("Selenium Provides the Actions API to chain actions together")
    public void selenium_provides_the_actions_api_to_chain_actions_together() {
        /*
            Selenium provides an Actions API which can be used when you need to chain
            multiple automation acts together, or when you need fine-tune control
            over the mouse, scroll wheel, keyboard, and/or electronic pen

            the build method returns an Action object that can be used later, the
            perform method builds the Action object and then performs the actions
            right away
         */
        wikiHome.openMainWikipediaPage();
        new Actions(driver)
                .moveToElement(driver.findElement(By.id("searchInput")))
                .click()
                .sendKeys("puppy")
                .moveToElement(driver.findElement(By.tagName("button")))
                .click()
                .perform();
        System.out.println(driver.getTitle());
    }
}
