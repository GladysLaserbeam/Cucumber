@product
Feature: Validation of Products

#  Scenario: Validation of New Product Creation
#    Given User navigates to product homepage and clicks Order Button
#    When User enters the product information 'MyMoney' and '4'
#    And User enters the address information 'Gladys','Midway','Mount Prospect','IL','00234'
#    And User enters the payment information '1234567891234567','12/23','VISA' and process the order
#    Then User validates the message 'Message'
#    And User clicks View All Orders and validates 'Name','Product','quantity','Street','City','State','Zip','Card','CardNumber','Expiration'

  Scenario Outline: Validation of New Product Creation
    Given User navigates to product homepage and clicks Order Button
    When User enters the product information '<product>' and '<quantity>'
    And User enters the address information '<CustomerName>','<street>','<city>','<state>','<zipCode>'
    And User enters the payment information '<cardNumber>','<expiredDate>','<cardType>' and process the order
    Then User validates the message '<message>'
    And User clicks View All Orders and validates '<CustomerName>','<product>','<quantity>','<street>','<city>','<state>','<zipCode>','<cardType>','<cardNumber>','<expiredDate>'
    Examples:
      | product     | quantity | CustomerName | street | city           | state | zipCode | cardNumber       | expiredDate | cardType         | message                                |
      | MyMoney     | 4        | Gladys       | Midway | Mount Prospect | IL    | 00234   | 1234567891234567 | 12/23       | Visa             | New order has been successfully added. |
      | FamilyAlbum | 16       | Jen          | oceana | Brooklyn       | NY    | 00234   | 1234567891234567 | 12/23       | MasterCard       | New order has been successfully added. |
      | ScreenSaver | 4        | Gladys       | Midway | Mount Prospect | IL    | 00234   | 1234567891234567 | 12/23       | American Express | New order has been successfully added. |
