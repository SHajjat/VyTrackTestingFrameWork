Feature: Login Functionality


  Scenario: User should be able to login with valid credentials
    Given user navigate to login page
    And user enter valid username and password
      | user     | Salesmanager101 |
      | password | UserUser123     |
    Then user should be able to see home page

  @wip
  Scenario Outline: Unauthorized used should not be able to login with invalid username
    Given user navigate to login page
    And user enter invalid "<username>" or invalid "<password>"
    Then user should see "Invalid user name or password."

    Examples:
      | username        | password        |
      | Salesmanager101 | Salesmanager101 |
      | Salesmanager101 | Userser123      |
      | Salesmanager101 | userUser123     |
      | Salesmanager10  | UserUser123     |
      | Salsmanager101  | UserUser123     |
      | salesmanager$   | UserUser123     |
      | UserUser123     | Salesmanager101 |
