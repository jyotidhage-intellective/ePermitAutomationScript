
Feature: Sample feature file

  @ePermitInternals_SmokeTest
  Scenario: User can open any existing case(except the case in draft status) and doesn’t get errors on all tabs
    Given User is on the login page
    Then User verify the username and password field on login page
    Then User login into the application by entering username and password
      | username | password |
      | p8admin_demo  | V3ga123456 |
    Then User is on the home page
    Then User click on "Personal Tasks" tab.
    Then User checks existing case is present in my application having status not Draft
    Then User open the existing case
    Then User check following tabs are present into the application
      |TabName|
      |Common Properties|
      |Application      |
      |Attachments|
      |Documents|
      |History/Comments|
    Then User able to render on "Case Details" tab without error in internal application
    Then User able to render on "Application" tab without error in internal application
    Then User able to render on "Attachments" tab without error in internal application
    Then User able to render on "Documents" tab without error in internal application
    Then User able to render on "History/Comments" tab without error in internal application