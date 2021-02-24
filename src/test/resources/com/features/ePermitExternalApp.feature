Feature: Smoke Test For External Application



    @ePermitExternal_Regression
  Scenario: Create New Application For Form C
      Given User is on the login page in external application
      Then User is on the home page
      Then User capture username and email_id from the profile tab
      Then User click on "My Permits" tab.
      Then User click on "New Application" button
      Then User check Creator and Email-id value is reflected from the users profile
      Then USer check that Application is marked as mandatory
      Then USer validate that correct list of applicationType is displayed
      |AffiliationList|
      |Section 401 Water Quality Certificate|
      |Structures, Dredging & Fill (SDF)       |
      |Structures, Dredging & Fill & Section 401 Water Quality Certificate (WQC)|
      |Structures, Dredging & Fill & Tidal Wetlands (TW)                        |
      |Structures, Dredging & Fill; TW; Section 401 WQC                         |
      Then user select application as "Section 401 Water Quality Certificate"
      Then User check the affiliation list for the selected application and check the "Applicant" and "Billing Contact" affiliation is mandatory
      Then User Check Next button is disabled
      Then Click on Create button and go through Common Affiliations wizard
      Then Click on "Next" button on commons io field.
      Then User select company_entity_indivisual as "Jyoti Dhage" and click on next button
      Then User select or add new address
      Then User Select or add new phone number
      Then user select or add new contact
      Then Add the different affiliation in the application



