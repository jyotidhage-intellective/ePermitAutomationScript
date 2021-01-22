Feature: Smoke Test For External Application
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