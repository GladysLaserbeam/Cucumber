Feature: Login Functionality with Scenario Outline

  Background:
    Given User navigates to the WebOrder

  Scenario: Validation of WebOrder Login Positive Scenario
    When User provides credentials 'guest1@microworks.com' and 'Guest1!' for WebOrder
    Then User validates the 'ORDER DETAILS - Weborder' from homepage

  Scenario Outline: Validation of WebOrder Login Negative Scenario
    #Given User navigates to the WebOrder
    When User provides credentials '<username>' and '<password>' for WebOrder
    Then User validates the '<message>' error message.
    Examples:
      | username              | password  | message        |
      | guest1@microworks.com | ahmet     | Sign in Failed |
      | gladys12@gmail.com    | Guest1!   | Sign in Failed |
      | gladys123@gmail.com   | gladys12  | Sign in Failed |
      |                       |           | Sign in Failed |
      | #$%^&*(%$$            | erfgrgbfg | message        |
      | ahemt                 | Guest1!   | message        |
      | guest1@microworks.com |           | message        |
