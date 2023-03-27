package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    Creating a private constructor, so we are closing access to the object of this class from outside  the class
    - actually we are preventing the creation of the Driver object.--->> Driver driver=new Driver(); this is impossible out of this class
     */
    private Driver() {
    }

    /*
    we make WebDriver private, because we want to close access from outside the class.
    We make it static because we will use it in a static method
     */
    //private static WebDriver driver; // value is null by default

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();


    /*
    Create a re-usable utility method which will return same driver instance when we call it
     */


    public static WebDriver getDriver() {

        if (driverPool.get() == null) {
            /*
            We read our browserType from configuration.properties
            This way, we can control which browser is opened from outside our code, from configuration.properties
             */

            /*
            Depending on the browserType that will return  from configuration.properties file switch statement will determine the case, and open the matching browser
             */

            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType) {
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    driverPool.set(new ChromeDriver());
//                    driverPool.get().manage().window().maximize();
//                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                    break;
                case "chrome":
                ChromeOptions options = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("intl.accept_languages", "en-GB");
                options.setExperimentalOption("prefs", prefs);
                WebDriverManager.chromedriver().setup();
                //WebDriver driver = new ChromeDriver(options);
                driverPool.set(new ChromeDriver(options));
                driverPool.get().manage().window().maximize();
                driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;


                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "chrome_english": //to set your chrome browser language as English during automation with Selenium
                WebDriverManager.chromedriver().setup();
                ChromeOptions optionsForEnglish = new ChromeOptions();
                optionsForEnglish.addArguments("--lang=eng-US");
                driverPool.set(new ChromeDriver(optionsForEnglish));
                driverPool.get().manage().window().maximize();
                driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                break;

            }

        }
        return driverPool.get();
    }

    public static void quitDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }

    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().close();
           driverPool.remove();
        }

    }


    //driver.quit() ---->>nosuchsession
    //drive.close() ---->>
    //try to create a method named closeDriver


}
