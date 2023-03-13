import org.openqa.selenium.support.PageFactory;
public class PageBaseClass {
    public PageBaseClass() {
        PageFactory.initElements(SingletonDriver.getDriver(), this);
    }
}
