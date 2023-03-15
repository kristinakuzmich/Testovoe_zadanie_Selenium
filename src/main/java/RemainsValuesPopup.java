import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class RemainsValuesPopup extends PageBaseClass {
    Expectation expectation=new Expectation();
    @FindBy(xpath = "//*[contains(@name, 'header-form:openWorkplaceBalanceDialogButton')]")
    private WebElement remainsValuesBtn;
    @FindBy(xpath = "//tr[@data-ri='0']/td[@class='-text-right']/span[@class='-text-strong']")
    private WebElement amountBynField;
    @FindBy(xpath = "//span[contains(text(),'Отменить')]")
    private WebElement cancelBtn;
    public void remainsValuesClick() {
        remainsValuesBtn.click();
        expectation.findIframe();
        WebElement element = driver.findElement(By.xpath("//div[@class='ui-dialog-content ui-widget-content ui-df-content']/iframe"));
        driver.switchTo().frame(element);
    }
    public String readAmountByn() {
        return amountBynField.getText();
    }
    public void cancelBtnClick() {
        cancelBtn.click();
        driver.switchTo().defaultContent();
        expectation.waitingMenuVisible();
    }
    public int getByn(){
        int amountByn = Integer.parseInt(readAmountByn().replaceAll("\\s+", "").replace(",00", ""));
        return amountByn;
    }
}