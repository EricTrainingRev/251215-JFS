Feature: Language Choice

  # anytime you have one or more shared starting conditions between your scenarios you can declare a background section
  # and declare those shared steps in the Background. These steps will be executed for each scenario in the file
  Background: shared starting condition
    Given   The user is on the main Wikipedia homepage

  Scenario: English readers can choose to browse Wikipedia in English
    When    The user clicks the english link
    Then    The user should be sent to the English homepage

  Scenario Outline: Readers of various languages can choose to browse Wikipedia in their own language
    When    The user clicks the "<language>" link
    Then    The user should be sent to a page with the title "<title>"

  Examples:
    |language|title|
    |Deutsch |Wikipedia – Die freie Enzyklopädie|
    |Polski  |Wikipedia, wolna encyklopedia|