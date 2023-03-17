import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class MainMenuPage extends PageBaseClass {
    Expectation expectation=new Expectation();
    @FindBy(xpath = "//form[@id='footer-form']/div[@class='session']/span[1]")
    private WebElement userMenu;
    @FindBy(xpath = "//*[contains(@id, 'left-menu-form:tabView:treeFilterInput')]")
    private WebElement searchField;
    @FindBy(xpath = "//span[@class='ui-growl-title']")
    private WebElement messText;
    @FindBy(xpath = "//button[@id='header-form:logoutLink']")
    private WebElement exitBtn;
    public String getUserName() {
        return userMenu.getText();
    }
    public void searchField(String value) {
        searchField.sendKeys(value);
        expectation.waitingMenuText(value);
        WebElement docField= driver.findElement(By.xpath("//span[contains(text(),'"+value+"')]"));
        docField.click();
        expectation.waitingLogoLoading();
    }
    public String getMessText() {
        return messText.getText();
    }
    public void exitCF() {
        exitBtn.click();
        expectation.waitingLoginFormVisible();
    }
    public void cleanField(){
        searchField.clear();
    }
}