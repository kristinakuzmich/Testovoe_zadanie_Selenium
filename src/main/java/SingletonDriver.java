import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonDriver {
    private static SingletonDriver instanceOfSingletonDriver = null;
    private WebDriver driver;

    private SingletonDriver() {
        System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public static SingletonDriver getInstanceOfSingletonDriver() {
        if (instanceOfSingletonDriver == null) {
            instanceOfSingletonDriver = new SingletonDriver();
        }
        return instanceOfSingletonDriver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}