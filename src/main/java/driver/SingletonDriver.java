package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class SingletonDriver {
    private static SingletonDriver instanceOfSingletonDriver = null;
    private WebDriver driver;
    private SingletonDriver() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
    }
    private static SingletonDriver getInstanceOfSingletonDriver() {
        if (instanceOfSingletonDriver == null) {
            instanceOfSingletonDriver = new SingletonDriver();
        }
        return instanceOfSingletonDriver;
    }
    public static WebDriver getDriver() {
        return getInstanceOfSingletonDriver().driver;
    }
    public static void closeDriver() {
        if (instanceOfSingletonDriver != null) {
            instanceOfSingletonDriver.driver.close();
        }
    }
}