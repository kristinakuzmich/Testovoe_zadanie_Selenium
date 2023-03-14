import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class MainMenuPage extends PageBaseClass {
    @FindBy(xpath = "//form[@id='footer-form']/div[@class='session']/span[1]")
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
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ajaxStatusPanel']/div[@style='display: none;']")));
    }
    public void clickDoc() {
        docField.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ajaxStatusPanel']/div[@style='display: none;']")));
    }
    public String getMessText() {
        return messText.getText();
    }
    public void exitCF() {
        exitBtn.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("formLogin")));
    }
}