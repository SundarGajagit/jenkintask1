Feature: Instagram Functionality testing

  Scenario: Instagram Login Credential testing
    Given User is on the instagram login page
    When User should enter the username and password
    And User should click the Login button
    Then User should verify the success message
