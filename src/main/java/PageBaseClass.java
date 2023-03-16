import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class PageBaseClass{
    WebDriver driver= SingletonDriver.getDriver();
    public PageBaseClass() {
        PageFactory.initElements(SingletonDriver.getDriver(), this);
    }
}
