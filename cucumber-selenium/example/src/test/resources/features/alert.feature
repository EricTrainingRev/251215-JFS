Feature: Selenium can handle Alerts and switch windows/tabs

  Background: The example page should be open
    Given   The example page is open

  Scenario: Selenium can manage alert pop ups when they appear
    When    The user clicks the button to make a popup appear
    Then    Selenium can interact with the popup
    And     Selenium can close the alert when done interacting with it
    # The And keyword can be used when you want to group multiple steps together logically, or you think that it will
    # make reading the acceptance criteria steps of your scenarios easier to read. This is a good point to note
    # how Cucumber uses the step keywords: if you generte your boilerplate code via Cucumber the Then and And statements
    # will both be given a @Then annotation. This is because Cucumber only uses the step keywords to recognize that a
    # new step has been reached: the semantic differences between given (starting condition), when (action), and then
    # (expected outcome) is only pertinent for the human reading the file/code. Cucumber does not enforce this semantic
    # meaning in any way: you could make everything a Given statement, and Cucumber would still execute just fine