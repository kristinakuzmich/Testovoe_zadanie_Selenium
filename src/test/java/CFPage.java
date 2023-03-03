import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class CFPage {
    public WebDriver driver;
    public CFPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath = "//span[text()='Кузьмич М.И.']")
    private WebElement userMenu;
    public String getUserName() {
        String userName = userMenu.getText();
        return userName;
    }
    public void entryMenu() {
        userMenu.click();
    }
}
