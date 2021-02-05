Feature: Smoke Test For External Application

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


