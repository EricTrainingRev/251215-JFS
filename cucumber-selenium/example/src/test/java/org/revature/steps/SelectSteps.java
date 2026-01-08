package org.revature.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;

import static org.revature.steps.SeleniumTestResources.examplePage;

public class SelectSteps {

    @When("we select a value from the select element")
    public void we_select_a_value_from_the_select_element() {
        /*
            When working with select elements we can convert the basic
            WebElement object into a Select element specifically
         */
        Select selectElement = new Select(examplePage.getSelect());
        /*
            Once you have your select element you can choose how you want to make
            your selection choice:
            - visible text
            - value
            - index position
         */
        selectElement.selectByVisibleText("1st");
        selectElement.selectByValue("first");
        selectElement.selectByIndex(0);
    }
    @Then("we can do things with that value")
    public void we_can_do_things_with_that_value() {
        Select selectElement = new Select(examplePage.getSelect());
        /*
            Once your selections have been made you can either choose to see all
            selected options via getAllSelectedOptions or just the first one via
            getFirstSelectedOption. Some select elements allow multiple options to be
            selected, so pick the get option most appropriate for the situation
         */
        System.out.println(selectElement.getFirstSelectedOption().getText());
    }
}
