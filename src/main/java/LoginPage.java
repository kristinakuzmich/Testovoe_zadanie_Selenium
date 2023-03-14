import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageBaseClass {
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("footer-form")));
    }
}
