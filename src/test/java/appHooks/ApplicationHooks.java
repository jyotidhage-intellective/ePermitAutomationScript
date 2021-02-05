package appHooks;

import com.factory.BaseAction;
import com.factory.DriverFactory;
import com.utility.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    private BaseAction baseAction;

    Properties prop;

    @Before(order = 0)
    public void getProperty(){
        configReader = new ConfigReader();
        prop = configReader.readPropertiesFile("config.properties");

    }
    @Before(order = 1)
    public void launch_Browser(){
        String browser = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver= driverFactory.startBrowser(browser);

    }

    @After(order=0)
    public void close_browser(){
        driver.quit();
    }
    @After(order=1)
    public void tearDown(Scenario scenario){
        String screenshotname = scenario.getName().replace(" ","-");
        byte []sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(sourcepath,"image/png",screenshotname);
    }


}

