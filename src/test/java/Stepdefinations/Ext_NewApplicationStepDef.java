package Stepdefinations;

import com.factory.BaseAction;
import com.factory.DriverFactory;
import com.pageObjectModel.CommonsApp;
import com.pageObjectModel.Ext_NewApplication;
import com.utility.Constants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class Ext_NewApplicationStepDef extends BaseAction {
    private Ext_NewApplication ext_newApplication = new Ext_NewApplication();
    private CommonsApp commonsApp = new CommonsApp();

    @Then("User click on {string} button")
    public void user_click_on_button(String newApplication) {
        ext_newApplication.clickonNewAppBtn(newApplication);
    }

    @Then("User capture username and email_id from the profile tab")
    public void user_capture_username_and_email_id_from_the_profile_tab() {
        ext_newApplication.captureUserNameEmail();
        System.out.println("User name is " + ext_newApplication.userName);
        System.out.println("User name is " + ext_newApplication.userEmailId);
    }

    @Then("User check Creator and Email-id value is reflected from the users profile")
    public void user_check_creator_and_email_id_value_is_reflected_from_the_users_profile() {
        ext_newApplication.validateUserNameandEmailId();
    }

    @Then("User Check Next button is disabled")
    public void user_check_next_button_is_disabled() {
        Assert.assertEquals(getWebElement("NextBtndisabled", "ExternalApp").isDisplayed(), true);

    }

    @Then("USer validate that correct list of applicationType is displayed")
    public void u_ser_validate_that_correct_list_of_applicationType_is_displayed(DataTable affliationList) {
        elementUtil.waitAndClick(getWebElement("ApplicationSearchIcon", "ExternalApp"), Constants.wait);
        List<WebElement> element = getWebElements("searchTable", "ExternalApp");
        if (element.size() > 1) {
//        elementUtil.fnGetNoOfRecordPresentnDashboard("Application Name");
            List<Map<String, String>> app_Name = affliationList.asMaps();
            for (Map<String, String> e : app_Name) {
                // getWebElement("Application","ExternalApp").sendKeys(e.get("AffiliationList")+ Keys.ENTER);
                try {
                    Assert.assertTrue(elementUtil.getSpanText(e.get("AffiliationList")).isDisplayed());
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        }
        elementUtil.waitAndClick(getWebElement("SearchIconClose", "ExternalApp"), Constants.wait);


    }

    @Then("USer check that Application is marked as mandatory")
    public void u_ser_check_that_application_is_marked_as_mandatory() {
        Assert.assertTrue(getWebElement("NewAppMAndatory", "ExternalApp").isDisplayed());
    }

    @Then("Click on Create button and go through Common Affiliations wizard")
    public void click_on_create_button_and_go_through_common_affiliations_wizard() {
        elementUtil.waitAndClick(elementUtil.getSpanText("Save"), Constants.wait);
        sleep(5000);
        elementUtil.waitAndClick(elementUtil.getSpanText("Create"), Constants.ProcessingWait);
        elementUtil.fnWaitForVisibility(elementUtil.getButtonText("Back"), Constants.ProcessingWait);
    }

    @Then("user select application as {string}")
    public void user_select_application_as(String formname) {
        elementUtil.setFocusEnter(getWebElement("Application", "ExternalApp"), formname);
    }

    @Then("User check the affiliation list for the selected application and check the {string} and {string} affiliation is mandatory")
    public void user_check_the_affiliation_list_for_the_selected_application_and_check_the_and_affiliation_is_mandatory(String applicant, String BillingContact) {
        elementUtil.fnWaitForVisibility(elementUtil.getSpanText(applicant), Constants.wait);
        elementUtil.moveToElement(elementUtil.getSpanText(applicant));
        sleep(300);
        elementUtil.fnWaitForVisibility(elementUtil.getText("Required"), Constants.wait);
        Assert.assertTrue(elementUtil.getText("Required").isDisplayed());
        elementUtil.fnWaitForVisibility(elementUtil.getText("Required"), Constants.wait);
        elementUtil.moveToElement(elementUtil.getSpanText(BillingContact));
        Assert.assertTrue(elementUtil.getText("Required").isDisplayed());
        ext_newApplication.fnAddAffiliationInList();
    }

    @Then("Click on {string} button on commons io field.")
    public void click_on_button_on_commons_io_field(String nextbtn) {
        // Write code here that turns the phrase above into concrete actions
        elementUtil.waitAndClick(elementUtil.getButtonText(nextbtn), Constants.wait);
        elementUtil.fnWaitForVisibility(getWebElement("SubsAggrement", "ExternalApp"), Constants.wait);
    }

    @Then("User select company_entity_indivisual as {string} and click on next button")
    public void user_select_company_entity_indivisual_as_and_click_on_next_button(String company) {
        ext_newApplication.fnSubscribeAggrement(company);
    }

    @Then("User select or add new address")
    public void user_select_or_add_new_address() {
        commonsApp.fnSelectAddress();
    }

    @Then("User Select or add new phone number")
    public void user_select_or_add_new_phone_number() {
        commonsApp.fnAddNewPhoneNo();
    }

    @Then("user select or add new contact")
    public void user_select_or_add_new_contact() {
        commonsApp.fnselectExistingContactPerson();
    }
    @Then("Add the different affiliation in the application")
    public void add_the_different_affiliation_in_the_application(){
        commonsApp.fnSelectaffiliaction("Yes");
    }

}