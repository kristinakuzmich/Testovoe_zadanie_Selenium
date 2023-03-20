package pages;

import Expectations.Expectation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBaseClass {
    Expectation expectation=new Expectation();
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
        expectation.waitingMenuVisible();
    }
}
