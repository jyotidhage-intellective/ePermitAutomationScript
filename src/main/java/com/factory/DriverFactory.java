package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
    public WebDriver driver ;
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    /*******
     * This method is used to initialized the browser
     *@param browser
     * @return
     */
    public WebDriver startBrowser(String browser) {
        if(browser.trim().equalsIgnoreCase("Chrome")){
            ChromeOptions options = new ChromeOptions();
            options.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
            options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
            options.addArguments("--start-maximized");
            options.addArguments("--disable-default-apps");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable.dev.shm.usage");
            options.setExperimentalOption("excludeSwithes", new String[] {"enable-automation"});
            options.setExperimentalOption("useAutomationExtension",false);
            String driverpath = System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver",driverpath);
            tlDriver.set(new ChromeDriver());
            setImplicitlyWait(com.utility.Constants.Implicit_Wait);

        }else if(browser.trim().equalsIgnoreCase("IE")){
            InternetExplorerOptions ieOption = new InternetExplorerOptions();
            ieOption.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,true);
            ieOption.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
            ieOption.setCapability("ignoreProtectedModeSettings", true);
            String driverpath = System.getProperty("user.dir") + "\\src\\test\\resources\\Drivers\\IEDriverServer.exe";
            System.setProperty("webdriver.ie.driver",driverpath);
            tlDriver.set(new InternetExplorerDriver(ieOption));
            setImplicitlyWait(100);
        }else{
            System.out.println("No Browser is selected for opening");
        }
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        return getDriver();
    }
    public  void setImplicitlyWait(int seconds) {
        getDriver().manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }
    /*
    *This method is to return the driver instance
     */
    public static synchronized WebDriver getDriver(){
        return tlDriver.get();
    }
}
