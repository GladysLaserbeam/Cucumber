Feature: Amazon search functionality
  Scenario: Positive scenario Amazon search
    Given User navigates to Amazon
    When User searches for iphone 13 case
    Then User validates the number is 40000 results on top that shown
    And User validates all headers contains iPhone
