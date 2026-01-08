Feature: Actions API and driver integration

  Background:
    Given   The example page is open

  Scenario: Actions api
    Then   Selenium Provides the Actions API to chain actions together

  Scenario: Driver integration
    Then    We can access the driver from within other WebElements