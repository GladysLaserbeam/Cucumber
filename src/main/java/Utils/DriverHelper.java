package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;

public class DriverHelper {
    //private variable
    private static WebDriver driver;

    //private constructor to make sure they do not create an object from this class
    private DriverHelper(){}

    public static WebDriver getDriver(){
        //if my driver is not instaniated before
        if(driver==null||((RemoteWebDriver)driver).getSessionId()==null){

            switch(ConfigReader.readProperty("browser")){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    //driver.manage().window().maximize(); instead of repeating this every case its better to add it on line 38
                    break;
                case"firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    //driver.manage().window().maximize();
                    break;
                default://if you forget to initialize which browser make it chrome
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                   // driver.manage().window().maximize();
                    break;

            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }
}
