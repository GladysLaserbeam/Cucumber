#Please navigate to the internet-heroku app. Click 10 of the links then validate the url.
# Do it with the scenario outline.
# CLUE: you can consider driver.findElement(By.linktext)
  Feature: HeroKuApp URL functionality
    Scenario: : Validation of Url
      Given User navigates to 'https://the-internet.herokuapp.com/'
    When User clicks on the 'link' on the mainpage
      And Validates the 'url' of the new page

