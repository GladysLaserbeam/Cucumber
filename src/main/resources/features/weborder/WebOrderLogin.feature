#Feature: Login Functionality of WebOrder Page
#
#  Scenario: Validation of WebOrder Login Scenario(correct username and password)
#    Given User navigates to the WebOrder
#    When User provides correct 'guest1@microworks.com' and 'Guest1!' for WebOrder
#    Then User validates the 'ORDER DETAILS - Weborder' from homepage
#
#  Scenario: Validation of WebOrder Login Scenario(correct username and wrong password)
#    Given User navigates to the WebOrder
#    When User provides correct 'guest1@microworks.com' and wrong 'ahmet' for WebOrder
#    Then User validates the 'Sign in Failed' error message.
#
#  Scenario: Validation of WebOrder Login Scenario(wrong username and correct password)
#    Given User navigates to the WebOrder
#    When User provides wrong 'ahmet@gmail.com' and correct 'Guest1!' for WebOrder
#    Then User validates the 'Sign in Failed' error message.
#
#  Scenario: Validation of WebOrder Login Scenario(empty username and empty password)
#    Given User navigates to the WebOrder
#    When User provides empty '' and empty '' for WebOrder
#    Then User validates the 'Sign in Failed' error message.


