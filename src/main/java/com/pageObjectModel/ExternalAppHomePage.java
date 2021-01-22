package com.pageObjectModel;

import com.utility.Constants;
import com.utility.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ExternalAppHomePage {
    private WebDriver driver;
    private ElementUtil elementUtil;

    public  ExternalAppHomePage(WebDriver driver, ElementUtil elementUtil){
        this.driver=driver;
        this.elementUtil=elementUtil;
    }

    public WebElement ExternalHomePage(){
        return driver.findElement(By.xpath("//h6[text()='Connecticut Department of Energy and Environmental Protection Permits and Licenses']"));
    }
    public WebElement getTab(String tabName){
        return driver.findElement(By.xpath("//button[@aria-label='"+tabName+"']"));
    }

    public void clickOnTab(String tabName){
        elementUtil.waitAndClick(getTab(tabName), Constants.wait);
    }

    public int checkRenderSuccessful(String colName){
        return elementUtil.fnGetNoOfRecordPresentnDashboard(colName);
    }
}
