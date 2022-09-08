@etsy
Feature:Etsy search functionality

  Scenario Outline: Validation Title of Etsy Search Hat
    Given User naviagates to 'https://www.etsy.com/'
    When user searches for '<SearchItem>'
    Then user sees and validates the title is '<title>'
    Examples:
    ## click command option L to align the rows
      | SearchItem | title |
      | Hat | Hat \| Etsy |
      | Key | Key \| Etsy |
      | Pin | Pin \| Etsy |
