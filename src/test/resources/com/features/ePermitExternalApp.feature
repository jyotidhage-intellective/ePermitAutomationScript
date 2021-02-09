Feature: Smoke Test For External Application

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


    @ePermitExternal_Regression
  Scenario: Create New Application For Form C
      Given User is on the login page in external application
      Then User is on the home page
      Then User capture username and email_id from the profile tab
      Then User click on "My Permits" tab.
      Then User click on "New Application" button
      Then User check Creator and Email-id value is reflected from the users profile
      Then USer check that Application is marked as mandatory
      Then USer validate that correct list of affiliations is displayed
      |AffiliationList|
      |Section 401 Water Quality Certificate|
      |Structures, Dredging & Fill (SDF)       |
      |Structures, Dredging & Fill & Section 401 Water Quality Certificate (WQC)|
      |Structures, Dredging & Fill & Tidal Wetlands (TW)                        |
      |Structures, Dredging & Fill; TW; Section 401 WQC                         |
      Then User Check Next button is disabled
      Then Click on Create button and go through Common Affiliations wizard


