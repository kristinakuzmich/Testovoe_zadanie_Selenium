import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBaseClass {
    private WebDriver driver;

    public PageBaseClass(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
