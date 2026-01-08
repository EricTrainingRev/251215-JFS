Feature: Selenium can switch tabs and windows

  Scenario: Opening a new tab and switching to it
    Given   A browser page is open somewhere
    When    Selenium is told to open a new tab
    Then    The new tab shoud be created