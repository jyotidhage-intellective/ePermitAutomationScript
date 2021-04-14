Feature: Smoke Test Execution For ePermit Internal Application
  @ePermitInternals_SmokeTest
  Scenario: All tabs are rendered without errors in Internal application
    Given User is on the login page
    Then User verify the username and password field on login page
    Then User login into the application by entering username and password
      | username | password |
      | p8admin_demo  | V3ga123456 |
    Then Title of the home page is "CT DEEP Permits and Licenses"
    Then User check following tabs are present into the application
    |TabName|
    |Supervisor Tasks|
    |Program Tasks   |
    |Personal Tasks  |
    Then User able to render on "Supervisor Tasks" tab without error in internal application
    Then User able to render on "Program Tasks" tab without error in internal application
    Then User able to render on "Personal Tasks" tab without error in internal application

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
    |Case Details|
    |Application |
    |Documents|
    |History/Comments|
    Then User able to render on "Case Details" tab without error in internal application
    Then User able to render on "Application" tab without error in internal application
    Then User able to render on "Documents" tab without error in internal application
    Then User able to render on "History/Comments" tab without error in internal application



  @ePermitExternal_SmokeTest
  Scenario: All tabs are rendered without errors in external application
    Given User is on the login page in external application
    Then User is on the home page
    Then User check tabs are present into the application
      |TabName|
      |My Drafts|
      |My Applications|
      |My Permits     |
      |Applications for Review|
      |Application Types      |
    Then User able to render on "My Drafts" tab without error
    Then User able to render on "My Applications" tab without error
    Then User able to render on "My Permits" tab without error
    Then User able to render on "Applications for Review" tab without error
    Then User able to render on "Application Types" tab without error

  @ePermitExternal_SmokeTest
  Scenario: User can open any existing case(except the case in draft status) and doesn’t get errors on all tabs
    Given User is on the login page in external application
    Then User is on the home page
    Then User click on "My Applications" tab.
    Then User checks existing case is present in my application having status not Draft
    Then User open the existing case
    Then User check following tabs are present into the application
      |TabName|
      |Common Properties|
      |Application      |
      |Attachments      |
      |Documents        |
      |History/Comments |
    Then User check application allow user to navigate on "Common Properties" tab without error
    Then User check application allow user to navigate on "Application" tab without error
    Then User check application allow user to navigate on "Attachments" tab without error
    Then User check application allow user to navigate on "Documents" tab without error
    Then User check application allow user to navigate on "History/Comments" tab without error




