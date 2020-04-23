@tag
Feature: The internet herokuapp
  @tag1
  Scenario: Verify Title of page 
    Given user open chrome browser 
    When user open url as "http://the-internet.herokuapp.com/"
    Then verify page title as "The Internet"
    And close chrome browser