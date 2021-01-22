Feature: Smoke Test Execution For ePermit Internal Application

  Scenario: Login to the ePermit internal application
    Given User is on the login page
    Then User verify the username and password field on login page
    Then User login into the application by entering username and password
      | username | password |
      | p8admin_demo  | V3ga123456 |
    Then Title of the home page is "CT DEEP Permits and Licenses"


