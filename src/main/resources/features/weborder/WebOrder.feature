@regression @smoke
Feature: WebOrder page Food Order Functionality

  # Navigate to the website and login successfully
  #Validate the ORDER DETAILS from order page
  #Click Group Order box and Click Next button
  #Choose my location is My House
  #Validate the adress contains 1854 Empire Blvd
  #Send the word for Note to Invitees part
  #send two gmail for Invite List
  #Click Create Group Order
  #Validate View Group Order header
  #Validate total participant is 1
  Background:
    #Given User navigates to the WebOrder
    Given  User provides credentials 'guest1@microworks.com' and 'Guest1!' for WebOrder
    When User validates the 'ORDER DETAILS - Weborder' from homepage
    And User clicks Group Order Box and Next Button
    And User sends the word 'Test' for Note to Invitees part
    And User sends e-mail addresses which are 'ahmet@gmail.com' and 'berkay@gmail.com' to Invite List

  Scenario: Testing the webOrder functionality for House
    And User chooses the delivery address 'My House' and validates the address '1854 Empire Blvd'
    And User clicks create group order button.
    Then User validates the header of page is 'View Group Order'
    And User validates total participant is 1

  Scenario: Testing the webOrder functionality for Office
    And User chooses the delivery address 'Office' and validates the address '2012 EMPIRE BLVD'
    And User clicks create group order button.
    Then User validates the header of page is 'View Group Order'
    And User validates total participant is 1
