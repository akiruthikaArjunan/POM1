package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver initDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");   // Headless mode
        options.addArguments("--no-sandbox");     // Required for Docker
        options.addArguments("--disable-dev-shm-usage"); // Prevents shared memory issues
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }
    public static WebDriver getDriver(){
        return driver;
    }
    public static void quitDriver(){
        if(driver!=null){
            driver.quit();
        }

    }
}
