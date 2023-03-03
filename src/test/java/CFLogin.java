import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class CFLogin {
    public WebDriver driver;
    public CFLogin(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
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
        loginBtn.click(); }
}