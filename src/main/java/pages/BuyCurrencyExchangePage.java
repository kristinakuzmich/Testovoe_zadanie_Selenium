package pages;
import Expectations.Expectation;
import buttons.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.math.BigDecimal;
public class BuyCurrencyExchangePage extends PageBaseClass{
    Expectation expectation=new Expectation();
    Button button=new Button();
    @FindBy(xpath = "//input[@id='main-content-form:dataTableId:0:inputSum_input']")
    private WebElement inputBuyCurrencyForCashField;
    public void inputAmount(BigDecimal amount){
        inputBuyCurrencyForCashField.click();
        expectation.waitingLogoLoading();
        inputBuyCurrencyForCashField.sendKeys(String.valueOf(amount));
        driver.findElement(By.tagName("h1")).click();
        expectation.waitingLogoLoading();
        BigDecimal sumToIssue=new BigDecimal(driver.findElement(By.xpath("//span[@id='main-content-form:dataTableId:0:outputSumText']")).getText().replace(",", "."));
        BigDecimal sumToBuy=new BigDecimal(driver.findElement(By.xpath("//div[@id='main-content-form:dataTableId:0:itemRate_content']/span[2]")).getText().replace(",", "."));
        BigDecimal number=sumToBuy.setScale(2).multiply(amount);
        Assert.assertEquals(sumToIssue,number);
        button.clickContinueBtn();
    }
}
