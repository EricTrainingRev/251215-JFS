package org.revature;

import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.Suite;

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

    For Cucumber we need to tell the software where the feature files are located and where the "glue" steps are
    located. Feature files provide the actual tests and their steps to Cucumber, whereas the glue files provide the
    implementation of the steps that actually are executed when we run our tests
 */
@Suite
@IncludeEngines("cucumber")
public class CucumberRunner {
}
