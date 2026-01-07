package org.revature.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExampleSteps {
    @Given("Some starting condition")
    public void some_starting_condition() {
        System.out.println("Set starting condition");
    }
    @When("Some action is taken")
    public void some_action_is_taken() {
        System.out.println("Perform some action");
    }
    @Then("Some result should be achieved")
    public void some_result_should_be_achieved() {
        System.out.println("validate the end results");
    }
}
