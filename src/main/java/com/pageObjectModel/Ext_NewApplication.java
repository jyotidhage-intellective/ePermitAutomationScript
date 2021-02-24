package com.pageObjectModel;

import com.factory.BaseAction;
import com.factory.DriverFactory;
import com.utility.Constants;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Ext_NewApplication extends BaseAction {
    private WebDriver driver= DriverFactory.getDriver();
    private String formNAme= "ExternalApp";
    public String userName;
    public String userEmailId;

    public void clickonNewAppBtn(String text){
        elementUtil.fnWaitForVisibility(getWebElement("NewApplicationBtn",formNAme), Constants.wait);
        elementUtil.waitAndClick(getWebElement("NewApplicationBtn",formNAme),Constants.wait);
        elementUtil.fnWaitForVisibility(getWebElement("Application",formNAme),Constants.wait);
    }
    public void captureUserNameEmail(){
        elementUtil.waitAndClick(getWebElement("ProfileIcon",formNAme),Constants.wait);
        userName = getWebElement("ProfileUsername",formNAme).getText();
        userEmailId = getWebElement("ProfileMailId",formNAme).getText();
        driver.navigate().refresh();
    }
    public void validateUserNameandEmailId(){
        elementUtil.fnWaitForVisibility(getWebElement("Creator",formNAme),Constants.wait);
        Assert.assertEquals(getWebElement("Creator",formNAme).getAttribute("value"),userName);
        Assert.assertEquals(getWebElement("Email",formNAme).getAttribute("value"),userEmailId);
    }
    public void fnAddAffiliationInList(){
        sleep(2000);
        List<WebElement> affiliation = getWebElements("AffiliationList","ExternalApp");
        for (int i = 1;i<affiliation.size();i++){
            String name = affiliation.get(i).getText();
            if(!name.isEmpty()){
                ListOfAffiliation.add(affiliation.get(i).getText());
            }
        }
    }
    public void fnSubscribeAggrement(String company){
        try {
            WebElement subsAggrement = getWebElement("SubsAggrement","ExternalApp");
            elementUtil.fnWaitForVisibility(subsAggrement, Constants.wait);
            if (subsAggrement.isDisplayed())
                selectComboboxSendKeys(subsAggrement, company);
            //Click on Next button
            elementUtil.sendKeysEnter(getWebElement("nextButtonNew","ExternalApp"));
            }catch (Exception e){
            e.printStackTrace();
        }
    }

}
