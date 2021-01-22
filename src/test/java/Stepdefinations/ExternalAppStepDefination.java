package Stepdefinations;

import com.factory.DriverFactory;
import com.pageObjectModel.ExternalAppHomePage;
import com.utility.Constants;
import com.utility.ElementUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class ExternalAppStepDefination {
    private ExternalAppHomePage externalAppHomePage = new ExternalAppHomePage(DriverFactory.getDriver(), new ElementUtil(DriverFactory.getDriver()));
    @Given("User is on the login page in external application")
    public void user_is_on_the_login_page_in_external_application() {
        DriverFactory.getDriver().get(Constants.externalAppURL);
    }
    @Then("User is on the home page")
    public void user_is_on_the_home_page() {
        Assert.assertTrue(externalAppHomePage.ExternalHomePage().isDisplayed());
    }
    @Then("User check tabs are present into the application")
    public void user_check_tabs_are_present_into_the_application(DataTable tabNameList) {
        List<Map<String,String>> TabName = tabNameList.asMaps();
        for(Map<String, String> e: TabName ){
                Assert.assertTrue(externalAppHomePage.getTab(e.get("TabName")).isDisplayed());
        }

    }
    @Then("User able to render on {string} tab without error")
    public void user_able_to_render_on_tab_without_error(String tabName) {
        externalAppHomePage.clickOnTab(tabName);
        if(externalAppHomePage.checkRenderSuccessful("Application Type") >  1){
            System.out.println(tabName +"is render without error");
        }
    }



}
