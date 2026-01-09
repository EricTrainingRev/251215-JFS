package com.revature.taskmanager.E2E.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.boot.test.context.SpringBootTest;

import static com.revature.taskmanager.E2E.fixtures.TestFixtures.*;

public class AdminLoginSteps {
    @Given("The user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginPage.openLoginPage();
    }
    @When("The Admin ents valid credentials")
    public void the_admin_ents_valid_credentials() {
        loginPage.enterCredentials("admin", "admin");
    }
    @When("clicks the login button")
    public void clicks_the_login_button() {
        loginPage.attemptLogin();
    }
    @Then("The Admin should be sent to the Admin portal")
    public void the_admin_should_be_sent_to_the_admin_portal() {
        wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe("http://localhost:4200/login")));
        Assertions.assertEquals("http://localhost:4200/admin", driver.getCurrentUrl());
    }
}
