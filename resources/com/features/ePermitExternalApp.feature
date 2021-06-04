Feature: Smoke Test For External Application

    @ePermitExternal_Regression
  Scenario: Create New Application For Form C
      Given User is on the login page in external application
      Then Read test data to this scenario from excel file
      Then User is on the home page
      Then User capture username and email_id from the profile tab
      Then User click on "My Drafts" tab.
      Then User click on "New Application" button
      Then User check Creator and Email-id value is reflected from the users profile
      Then USer check that Application is marked as mandatory
#      Then USer validate that correct list of applicationType is displayed
#      |AffiliationList|
#      |Section 401 Water Quality Certificate|
#      |Structures, Dredging & Fill (SDF)       |
#      |Structures, Dredging & Fill & Section 401 Water Quality Certificate (WQC)|
#      |Structures, Dredging & Fill & Tidal Wetlands (TW)                        |
#      |Structures, Dredging & Fill; TW; Section 401 WQC                         |
      Then user select application as "Section 401 Water Quality Certificate"
      Then User check the affiliation list for the selected application and check the "Applicant" and "Billing Contact" affiliation is mandatory
      Then User Check Next button is disabled
      Then User Capture Case Id from the URL Of the application
      Then Click on Create button and go through Common Affiliations wizard
      Then Click on "Next" button on commons io field.
      Then User select company_entity_indivisual as "Jyoti Dhage" and click on next button
      Then User select or add new address
      Then User Select or add new phone number
      Then user select or add new contact
      Then Add the different affiliation in the application
      #Then User open the created ePermiting case
      Then After click on next button application navigated to Application tab
      Then USer validate that Affiliation control presents the same data that was entered in the wizard and Next button is enabled
      Then User click on Next button and validate correct data is populated on next screen
       Then User validate that site address validation works for valid address
        |Street|City|State|ZipCode|
        |234 Elm|Haltfort|CT|0152 |
        |60 State St|Wethersfield|CT|06123|
      Then User select Muncipal Zonning as 'Yes' Q2 of PartIII
      Then User select multiple value in waterbody Q3 of PartIII
      Then User select Indian Lands option as 'Yes' Q4 of PartIII
      Then User Validate that logic for hidden fields works in Part III_Q5 after selecting Yes-LavelA-Yes
      Then User select Conservation or Preservation restration option as 'Yes' Q6 of PartIII
      Then User validate that new rows can be added to the table in Part III_Q7
      Then User select soil and_or groundwater remediation option as 'No' Q8 of PartIII
      Then User select Enforcement History option as 'No' Q9 of PartIII
      Then User select REGULATORY LIMIT option as 'Coastal Jurisdiction Line' Q10 of PartIII
      Then User enter value in Tidal Elevations in Q11 of PartIII
      Then User validate that logic works in Part III_Q12 when user checks Beaches or Dunes and when check Wildlife
      Then User fill the information in Part IV Project Information tab
      Then User fill the information in Part V: Engineering Support Documentation and Certification tab
      Then User validate that Next button becomes available only after all required fields are populated
      Then After click on Next button and attach documents for required attachments
      Then User click on Next button and validate that Certifier Agreement and Certifier signature is displayed
      Then User Fill out checking data for payment and finish the payment

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




