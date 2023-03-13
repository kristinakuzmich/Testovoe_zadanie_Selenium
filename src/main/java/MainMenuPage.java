import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class MainMenuPage extends PageBaseClass {
    @FindBy(xpath = "//span[text()='Кузьмич М.И.']")
    private WebElement userMenu;
    @FindBy(xpath = "//*[contains(@id, 'left-menu-form:tabView:treeFilterInput')]")
    private WebElement searchField;
    @FindBy(xpath = "//span[contains(text(),'Прием по документам')]")
    private WebElement docField;
    @FindBy(xpath = "//span[@class='ui-growl-title']")
    private WebElement messText;
    @FindBy(xpath = "//button[@id='header-form:logoutLink']")
    private WebElement exitBtn;
    public String getUserName() {
        return userMenu.getText();
    }
    public void searchField(String value) {
        searchField.sendKeys(value);
    }
    public void clickDoc() {
        docField.click();
    }
    public String getMessText() {
        return messText.getText();
    }
    public void exitCF() {
        exitBtn.click();
    }

}
