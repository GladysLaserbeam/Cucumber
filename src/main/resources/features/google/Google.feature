Feature: Testing google functionality

  Scenario: Happy path Google search functionality
    Given User navigates to the google
    When User searches for Techtorial
    Then User gets more than 10 links on the google page
