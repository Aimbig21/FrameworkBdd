Feature: Google search functionality

  Scenario: User searches for a keyword on Google
    Given User is on the Google homepage
    When User enters a search keyword "Selenium" in the search box
    And User presses the search button
    Then The search results should be displayed