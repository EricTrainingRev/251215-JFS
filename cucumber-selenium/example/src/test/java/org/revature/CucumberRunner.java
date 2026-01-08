package org.revature;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.openqa.selenium.WebDriver;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

/*
    In order to make Cucumber and Junit5 work together we have to tell Junit that
    this class is a test runner that provides information about a suite of tests. We
    also have to provide Cucumber with any configuration information it needs.

    Junit5 annotations
    @Suite -> tells Junit the class is a facilitator for other test resources. It does not
              contain its own test methods, but it instead provides configurations, links,
              and other static test resources for your tests that are defined in other
              locations
    @IncludeEngines -> this tells Junit what other test resource will be part of this test
                       suite. This is how we include Cucumber and its capabilities in our
                       tests
    @SelectPackages -> this tells Junit what parts of the test code to include as part of the suite. For our purposes
                       we tell Junit to include the package where we will define our glue steps and where our feature
                       files are located. Cucumber needs both of these to work properly
    @ConfigurationParameter -> this is how we provide custom configurations to Junit and any other test software we
                               are using. For our purposes we can set some custom Cucumber configurations, such as
                               where the glue steps are located and what optional plugins we want to use

    For Cucumber we need to tell the software where the feature files are located and where the "glue" steps are
    located. Feature files provide the actual tests and their steps to Cucumber, whereas the glue files provide the
    implementation of the steps that actually are executed when we run our tests
 */
@Suite
@IncludeEngines("cucumber")
@SelectPackages({"org.revature.steps", "features/current"})
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.revature.steps")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-report.html")
public class CucumberRunner {}
