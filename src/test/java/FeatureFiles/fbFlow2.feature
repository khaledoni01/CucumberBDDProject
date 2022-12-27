#FB_Data.xlsx@Login
Feature: Verify the FB Login and registration feature 2

  @sanity
  Scenario Outline: Verify the FB Login and Registration flows 3
    Given user has landed on Facebook login page
    When user provides facebook login credentials "<username>" and "<password>"
    And user provides facebook registration details

    Examples: Test data for FB flows
      | username | password |
      | j1       | abc123   |

  @sanity
  Scenario Outline: Verify the FB Login and Registration flows 4
    Given user has landed on Facebook login page
    When user provides facebook login credentials "<username>" and "<password>"
    And user provides facebook registration details

    Examples: Test data for FB flows
      | username | password |
      | flow4    | test123  |
      | flow4    | test123  |

  @sanity
  Scenario Outline: Verify the FB Login and Registration flows 5
    Given user has landed on Facebook login page
    When user provides facebook login credentials "<username>" and "<password>"
    And user provides facebook registration details

    Examples: Test data for FB flows
      | username | password |
      | flow5    | test123  |
