package Stepdefinations;

import com.factory.DriverFactory;
import com.pageObjectModel.ExternalAppHomePage;
import com.utility.ElementUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ExtAppMyApplicationStepDefination {

    private ExternalAppHomePage externalAppHomePage = new ExternalAppHomePage(DriverFactory.getDriver(), new ElementUtil(DriverFactory.getDriver()));
    @Then("User click on {string} tab.")
    public void user_click_on_tab(String tabName) {
        externalAppHomePage.clickOnMyAppTab(tabName);

    }

    @Then("User checks existing case is present in my application having status not Draft")
    public void user_checks_existing_case_is_present_in_my_application_having_status_not_draft() {
        int recNo=externalAppHomePage.checkRenderSuccessful("Application Type");
        if(recNo >=  1) {
            System.out.println("Record is present in the My application menu");
        }

    }

    @Then("User open the existing case")
    public void user_open_the_existing_case() {
        int recNo=externalAppHomePage.checkRenderSuccessful("Application Type");
        if(recNo >=  1) {
            externalAppHomePage.ContextClickOn1stRow(recNo);

        }
    }

    @Then("User check following tabs are present into the application")
    public void user_check_following_tabs_are_present_into_the_application(DataTable tabNameList) {
        List<Map<String,String>> TabName = tabNameList.asMaps();
        for(Map<String, String> e: TabName ){
            Assert.assertTrue(externalAppHomePage.existingtabName(e.get("TabName")).isDisplayed());
        }

    }

    @Then("User check application allow user to navigate on {string} tab without error")
    public void user_check_application_allow_user_to_navigate_on_tab_without_error(String tabName) {
        externalAppHomePage.clickOnExistingCaseTab(tabName);
    }



}
