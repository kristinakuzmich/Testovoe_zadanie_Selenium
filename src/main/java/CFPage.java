import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CFPage extends PageBaseClass {

    @FindBy(xpath = "//span[text()='Кузьмич М.И.']")
    private WebElement userMenu;

    public String getUserName() {
        return userMenu.getText();
    }

    public void entryMenu() {
        userMenu.click();
    }
}