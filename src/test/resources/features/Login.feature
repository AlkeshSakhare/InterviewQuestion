@Login
Feature: Login feature
  I want to use this template for my feature file

  @tag1
  Scenario: Verify login as data tables
    Given I open chrome browser
    And open url as "C:\Users\Alkesh\Desktop\login.html"
    When I enter <username> and <password>
      | aabb1122 | alkesh |
      | alkesh   | alkesh   |
    And click on login button
    Then I validate login user