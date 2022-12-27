#FB_Data.xlsx@Login

Feature: Verify the FB Login and registration feature

  @sanity
  Scenario Outline: Verify the FB Login and Registration flows 1
    Given user has landed on Facebook login page
    When user provides facebook login credentials "<username>" and "<password>"
    And user provides facebook registration details

    Examples: Test data for FB flows
      | username | password |
      | john     | abc123   |

  @sanity
  Scenario Outline: Verify the FB Login and Registration flows 2
    Given user has landed on Facebook login page
    When user provides facebook login credentials "<invalidUsername>" and "<invalidPassword>"
    And user provides facebook registration details

    Examples: Test data for FB flows
      | username | password | invalidUsername | invalidPassword |
      ##FB_Data.xlsx@Login
