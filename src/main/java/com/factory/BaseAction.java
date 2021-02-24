package com.factory;

import com.utility.Configuration;
import com.utility.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BaseAction {
    private WebDriver driver = DriverFactory.getDriver();
    public Configuration conf =Configuration.read();
    public ArrayList<String> ListOfAffiliation = new ArrayList<>();
    public ElementUtil elementUtil = new ElementUtil(driver);


    public Configuration getConf() {
        return conf;
    }

    public WebElement getWebElement(String name,String formName) {
        return getConf().getWebElement(driver, formName, name);
    }
    public List<WebElement> getWebElements(String name, String formName) {
        List<WebElement> webElement=getConf().getWebElementes(driver, formName, name);
        return webElement;
    }
    public void sleep(int Timer){
        try{
            Thread.sleep(Timer);
        }catch (Exception e){

        }
    }
    public boolean selectComboboxSendKeys(WebElement element,String Value){
        boolean exist;
        elementUtil.setFocus(element,Value);
        String valueXpath = "//option[contains(text(),'"+Value+"')]";
        try{
            WebElement item = getElement(valueXpath);
            if(item.isDisplayed()) {
                item.click();
                elementUtil.sendKeysEnter(element);
            }
            exist = true;
        }catch (Exception e){
            exist = false;
            e.printStackTrace();
        }
        return exist;
    }
    public WebElement getElement(String xpath){
        return driver.findElement(By.xpath(xpath));
    }
    public boolean selectCombobox(WebElement element,String Value){
        boolean exist;
        elementUtil.setFocusClick(element);
        elementUtil.sendKeysDownClick(element);
        String valueXpath = "//option[text()='"+Value+"']";
        try{
            WebElement item =  getElement(valueXpath);
            item.click();
            elementUtil.sendKeysEnter(element);
            exist = true;
        }catch (Exception e){
            exist = false;
        }
        return exist;
    }
    public void selectComboboxcontainsindivisual(WebElement element,String Value) {
        boolean exist;
        elementUtil.setFocusClick(element);
       elementUtil.sendKeysDownClickEnter(element);
    }

}

