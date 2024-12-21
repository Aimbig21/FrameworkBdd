Feature: Book a flight on MakeMyTrip

  Scenario: Login and book a flight from Hyderabad to Rajahmundry
    Given User is on the MakeMyTrip homepage
    When User logs in with username "user@example.com" and password "password123"
    And User searches for a flight from "Hyderabad" to "Rajahmundry" for tomorrow's date
    And User selects an Indigo flight
    Then User proceeds to the checkout page
    And User grabs the text from the checkout page