package org.revature.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static org.revature.steps.SeleniumTestResources.driver;
import static org.revature.steps.SeleniumTestResources.wikiHome;

public class WikiNavigation {

    @Given("The user is on the main Wikipedia homepage")
    public void the_user_is_on_the_main_wikipedia_homepage() {
        wikiHome.openMainWikipediaPage();
    }
    @When("The user clicks the english link")
    public void the_user_clicks_the_english_link() {
        wikiHome.clickEnglishLink();
    }
    @Then("The user should be sent to the English homepage")
    public void the_user_should_be_sent_to_the_english_homepage() {
        Assertions.assertEquals("Wikipedia, the free encyclopedia", driver.getTitle());
    }
}
