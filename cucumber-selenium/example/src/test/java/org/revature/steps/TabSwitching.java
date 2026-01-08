package org.revature.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static org.revature.steps.SeleniumTestResources.driver;

public class TabSwitching {

    @Given("A browser page is open somewhere")
    public void a_browser_page_is_open_somewhere() {
        driver.get("https://www.wikipedia.org/");
        System.out.println(driver.getTitle());
        /*
            Anytime you expect to hop between tabs/windows during your automation you
            should consider saving window handle information. You can tell Selenium
            to focus on a window by providing the Window Handle identifier to Selenium.

            Keep in mind that Selenium does not follow the "focus" of the browser like
            a person: if we open a new tab in the browser often the browser will shift
            the focus to that new tab. Selenium does not utilize this shift focus provided
            by the browser: if you want Selenium to interact with a new window you must tell
            it explicitly to focus on the new window
         */
        System.out.println(driver.getWindowHandle());
    }
    @When("Selenium is told to open a new tab")
    public void selenium_is_told_to_open_a_new_tab() {
        /*
            When switching to a new tab or window you use the switchTo method to get
            access to the newWindow method. You can then state whether you want the
            new window to be a tab or actual new window. Selenium provides constant
            values that indicate which type of new window you want
         */
        driver.switchTo().newWindow(WindowType.TAB);
    }
    @Then("The new tab shoud be created")
    public void the_new_tab_shoud_be_created() {
        /*
            Having switched focus in the previous step we can now go to a new page
            and still have the old instance available
         */
        driver.get("C:\\Users\\EricSuminski\\Desktop\\251215-JFS\\cucumber-selenium\\example\\src\\test\\resources\\example-page.html");
        System.out.println(driver.getTitle());
        System.out.println(driver.getWindowHandle());
        /*
            If you do need to hop back and forth, follow the example given in the documentation for changing the focused
            window
         */
        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[0]);
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.not(ExpectedConditions.titleIs("Example Page")));
        System.out.println(driver.getTitle());
    }

}
