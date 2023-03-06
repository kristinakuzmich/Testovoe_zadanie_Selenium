import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CFPage extends PageBaseClass {

    public CFPage(WebDriver driver) {
        super(driver);
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