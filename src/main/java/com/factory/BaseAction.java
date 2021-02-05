package com.factory;

import com.utility.Configuration;
import com.utility.ElementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BaseAction {
    private WebDriver driver = DriverFactory.getDriver();
    public Configuration conf =Configuration.read();
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
}

