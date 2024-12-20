Feature: Google search functionality

  Scenario: User searches for "Selenium" on Google
    Given User is on the Google homepage
    When User enters the search keyword "Selenium" in the search box
    Then the entered text should be "Selenium"

  Scenario: User searches for "Java" on Google
    Given User is on the Google homepage
    When User enters the search keyword "Java" in the search box
    Then the entered text should be "Java"
