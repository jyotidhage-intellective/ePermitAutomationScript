package com.pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;
    private By headerOfLoginPage = By.xpath("//h1[text()='Sign in to Unity']");


    private By userName = By.name("username");
    private By passWord = By.name("password");
    private By signInbtn = By.xpath("//span[text()='Sign In']");
    private By stateOfCTLogo = By.xpath("//img[@alt='State of Connecticut']");

    public  LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public void getTitle(){
        driver.getTitle();
    }
    public void EnterUserName(String UserId){
        driver.findElement(userName).sendKeys(UserId);
    }
    public void EnterPassword(String Pwd){
        driver.findElement(passWord).sendKeys(Pwd);
    }
    public void clickOnSignInBtn(){
        driver.findElement(signInbtn).click();
    }
    public void doLogin(String Uid, String Pwd){
        EnterUserName(Uid);
        EnterPassword(Pwd);
        clickOnSignInBtn();
    }

    public boolean getStateofCtLogo() {
        return driver.findElement(stateOfCTLogo).isDisplayed();
    }

    public WebElement getUserName() {
        return driver.findElement(userName);
    }
    public WebElement getPassWord() {
        return driver.findElement(passWord);
    }
    public String TitleOfPageAfterLogin(){
        return driver.getTitle();
    }


}
