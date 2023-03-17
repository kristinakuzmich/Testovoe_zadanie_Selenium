import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.math.BigDecimal;
public class IssuanceAcceptionPage extends PageBaseClass {
    Expectation expectation=new Expectation();
    @FindBy(xpath = "//input[@id='main-content-form:input-table:0:received_input']")
    private WebElement amountField;
    @FindBy(xpath = "//*[contains(@id, 'main-content-form:confirm')]")
    private WebElement continueBtn;
    public void inputAmount(BigDecimal amount) {
        amountField.click();
        amountField.sendKeys(String.valueOf(amount));
        clickContinueBtn();
    }
    public void clickContinueBtn() {
        continueBtn.click();
        expectation.waitingLogoLoading();
    }
}
