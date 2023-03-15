import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class PageBaseClass {
    WebDriver driver=SingletonDriver.getDriver();
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public PageBaseClass() {
        PageFactory.initElements(SingletonDriver.getDriver(), this);
    }
}
