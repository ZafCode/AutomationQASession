package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            synchronized (Driver.class) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setAcceptInsecureCerts(true);
                driverPool.set(new ChromeDriver());
            }
        }
        return driverPool.get();
    }
}
