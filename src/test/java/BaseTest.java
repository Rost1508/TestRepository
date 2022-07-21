import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


import org.openqa.selenium.remote.CapabilityType;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BaseTest {



    protected WebDriver driver;
    protected CalculatorPage calculatorPage;

    public WebDriver getDriver(){
        return driver;
    }

    @BeforeClass
    public void classLevelSetup(){
        System.setProperty("webdriver.chrome.driver", "src/chromedriver");
        String downloadFilepath = "/home/user/project/thynk-selenium/TemporaryFiles";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        ChromeOptions options= new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        options.addArguments("--incognito");
        options.addArguments("--disable-cache");
        options.addArguments("--disk-cache-size=1");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments(" --whitelisted-ips=\"\"");
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void methodLevelSetup(){
        calculatorPage = new CalculatorPage(driver);
    }

    /*@AfterClass
    public void teardown(){
        driver.close();
        driver.quit();
        if (driver != null) {
            driver = null;
        }
   }*/

}
