@etsy
Feature:Etsy search functionality

  Scenario: Validation Title of Etsy Search Hat
    Given User naviagates to 'https://www.etsy.com/'
    When user searches for 'Hat'
    Then user sees and validates the title is 'Hat | Etsy'

  Scenario: Validation Title of Etsy Search Key
    Given User naviagates to 'https://www.etsy.com/'
    When user searches for 'Key'
    Then user sees and validates the title is 'Key | Etsy'

  Scenario: Validation Title of Etsy Search Pin
    Given User naviagates to 'https://www.etsy.com/'
    When user searches for 'Pin'
    Then user sees and validates the title is 'Pin | Etsy'
