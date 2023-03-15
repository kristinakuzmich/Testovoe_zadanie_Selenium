import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class IssuanceAcceptionPage extends PageBaseClass {
    @FindBy(xpath = "//input[@id='main-content-form:input-table:0:received_input']")
    private WebElement amountField;
    @FindBy(xpath = "//*[contains(@id, 'main-content-form:confirm')]")
    private WebElement continueBtn;
    public void inputAmount(Integer amount) {
        amountField.click();
        amountField.sendKeys(String.valueOf(amount));
    }
    public void clickContinueBtn() {
        continueBtn.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ajaxStatusPanel']/div[@style='display: none;']")));
    }
}
