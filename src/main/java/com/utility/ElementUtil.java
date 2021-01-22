package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ElementUtil {
private WebDriver driver;

public  ElementUtil(WebDriver driver){
    this.driver=driver;
}

    public void waitAndClick(final WebElement element, int waitfor) {
        WebDriverWait wait = new WebDriverWait(driver, waitfor);
        wait.until(new ExpectedCondition<WebElement>() {
            public ExpectedCondition<WebElement> visibilityOfElement = ExpectedConditions.visibilityOf(element);
            @Override
            public WebElement apply(WebDriver driver) {
                try {
                    WebElement elementx = this.visibilityOfElement.apply(driver);
                    if (elementx == null) {
                        return null;
                    }
                    if (elementx.isDisplayed() && elementx.isEnabled())  {
                        elementx.click();
                        return elementx;
                    } else {
                        return null;
                    }
                } catch (WebDriverException e) {
                    return null;
                }
            }
        });
    }
    public int fnGetNoOfRecordPresentnDashboard(String colName)
    {
        String colValue=null;
        String tableId = getTableIdUsingColName(colName);
        if(tableId.length()>4)
            tableId=tableId.substring(0,4);
        List<WebElement> rows = GridTable(tableId);
        int rowNo = rows.size();
        // for (int t = 1; t <= rowNo; t++) {
        //String idNumber = splitefun(recordNo(tableId, t,configTestRunner.driver).getAttribute("class"));
        //CategoryName
        // WebElement element =GetTextFieldData(tableId, 1, getIDOfCol(configTestRunner,colName),configTestRunner.driver);
        //colValue = element.getText();
        // }
        return rowNo;
    }
    public String getTableIdUsingColName(String columnname){
        String Id =getIdOfElement(getThOfTableHeader(columnname));
        if(Id.length()>3){
            String Id1 =Id.substring(0,3);
            Id=Id1;
        }
        WebElement element = driver.findElement(By.xpath("//table[.//td[contains(@class,'"+Id+"')]]"));
        return getIdOfElement(element);
    }
    public List<WebElement> GridTable(String id){
        return driver.findElements(By.xpath("//table[contains(@class,'jss"+id+"')]//tbody//tr"));
    }
    public WebElement getThOfTableHeader(String text){
        WebElement element = driver.findElement(By.xpath("//th[//span[text()='"+ text +"']]"));
        return element;
    }
    public String getIdOfElement(WebElement element){
        String numid;
        String idnum = element.getAttribute("class");
        String nums = idnum.replaceAll("[^0-9 ]", "").replaceAll(" +", " ").trim();
        if(!(nums.isEmpty()))
            numid=nums;
        else
            numid=null;
        return numid;
    }
}

