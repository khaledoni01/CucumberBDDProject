Feature: Verify the FB Login and registration feature

  Scenario: Verify the FB Login and Registration flows 1
    Given user has landed on Facebook login page
    When user provides facebook login credentials "john" and "abc123"
    And user provides facebook registration details


  Scenario Outline: Verify the FB Login and Registration flows 1
    Given user has landed on Facebook login page
    When user provides facebook login credentials "<username>" and "<password>"
    And user provides facebook registration details

    Examples: Test data for FB flows
      | username | password |
      | john     | abc123   |
