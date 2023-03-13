import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AissuanceAcceptionPage extends PageBaseClass {


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
    }
}
