Feature: Language Choice

  Scenario: English readers can choose to browse Wikipedia in English
    Given   The user is on the main Wikipedia homepage
    When    The user clicks the english link
    Then    The user should be sent to the English homepage