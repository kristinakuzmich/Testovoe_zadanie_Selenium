import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CFLogin extends PageBaseClass {

    @FindBy(xpath = "//*[contains(@id, 'j_username')]")
    private WebElement loginField;
    @FindBy(xpath = "//*[contains(@id, 'j_password')]")
    private WebElement passwdField;
    @FindBy(xpath = "//*[contains(@id, 'loginButton')]")
    private WebElement loginBtn;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }

    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }

    public void clickLoginBtn() {
        loginBtn.click();
    }
}
