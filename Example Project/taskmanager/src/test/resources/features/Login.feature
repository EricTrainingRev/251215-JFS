Feature: Login

  Background:
    Given   The user is on the login page

  Scenario: Admin can log in to the Admin portal
    When    The Admin ents valid credentials
    And     clicks the login button
    Then    The Admin should be sent to the Admin portal