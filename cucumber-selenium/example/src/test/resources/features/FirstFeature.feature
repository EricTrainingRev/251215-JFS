# The basic components of a feature file are the Feature, Scenario/s, and steps
# The syntax being used here is called "gherkin syntax"

# The Feature section tells us what feature or resource is being tested. Feature files
# should only have one feature
Feature: This is the overall thing being tested

  # Scenarios represent tests that are related to your Feature. These tests can be
  # positive and/or negative tests, depending on the requirements of the feature,
  # and multiple scenarios are supported in a single feature file. Think of each
  # scenario in your feature files as the actual tests of the file
  Scenario: This is a specific aspect of the feature being tested

    # Your steps, or acceptance criteria, go after your scenario statement. These are
    # the actual implementation of your scenarios that have code associated with them.
    # Similar to junit tests, a step is considered to "pass" if it does not throw an
    # unhandled exception
    Given   Some starting condition
    When    Some action is taken
    Then    Some result should be achieved
