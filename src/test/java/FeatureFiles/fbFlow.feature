Feature: Verify the FB Login and registration feature

  Scenario: Verify the FB Login and Registration flows 1
    Given user has landed on Facebook login page
    When user provides facebook login credentials "John" and "abc123"
    Then user should be able to login

  Scenario Outline: Verify the FB Login and Registration flows 2
    Given user has landed on Facebook login page
    When user provides facebook login credentials "<username>" and "<password>"
    And user clicks on login button
    Then user should be able to login

    Examples: Test data for FB flows
      | username | password |
      | John     | abc123   |
      | Tom      | abc123   |