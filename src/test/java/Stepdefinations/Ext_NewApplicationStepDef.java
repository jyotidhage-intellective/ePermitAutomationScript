package Stepdefinations;

import com.factory.BaseAction;
import com.pageObjectModel.Ext_NewApplication;
import com.utility.Constants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;
import java.util.Map;

public class Ext_NewApplicationStepDef extends BaseAction {
    private Ext_NewApplication ext_newApplication = new Ext_NewApplication();

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

    @Then("USer validate that correct list of affiliations is displayed")
    public void u_ser_validate_that_correct_list_of_affiliations_is_displayed(DataTable affliationList) {
        elementUtil.waitAndClick(getWebElement("ApplicationSearchIcon","ExternalApp"), Constants.wait);
//        elementUtil.fnGetNoOfRecordPresentnDashboard("Application Name");
        List<Map<String,String>> app_Name = affliationList.asMaps();
        for(Map<String, String> e: app_Name ) {
       // getWebElement("Application","ExternalApp").sendKeys(e.get("AffiliationList")+ Keys.ENTER);
        Assert.assertTrue(elementUtil.getSpanText(e.get("AffiliationList")).isDisplayed());
        }
        elementUtil.waitAndClick(getWebElement("SearchIconClose","ExternalApp"),Constants.wait);
        elementUtil.setFocusEnter(getWebElement("Application","ExternalApp"),"Section 401 Water Quality Certificate");

    }
    @Then("USer check that Application is marked as mandatory")
    public void u_ser_check_that_application_is_marked_as_mandatory() {
        Assert.assertTrue(getWebElement("NewAppMAndatory","ExternalApp").isDisplayed());
    }
    @Then("Click on Create button and go through Common Affiliations wizard")
    public void click_on_create_button_and_go_through_common_affiliations_wizard() {
        elementUtil.waitAndClick(getWebElement("CreateBtn","ExternalApp"),Constants.wait);
    }



}