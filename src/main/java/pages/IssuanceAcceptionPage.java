package pages;
import Expectations.Expectation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.math.BigDecimal;
public class IssuanceAcceptionPage extends PageBaseClass {
    Expectation expectation=new Expectation();
    @FindBy(xpath = "//input[contains(@id,'main-content-form')][1]")
    private WebElement amountField;
    public void inputAmount(BigDecimal amount) {
        amountField.click();
        amountField.sendKeys(String.valueOf(amount));
    }
}
