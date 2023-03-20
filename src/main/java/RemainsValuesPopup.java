import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.math.BigDecimal;
public class RemainsValuesPopup extends PageBaseClass {
    Expectation expectation=new Expectation();
    BigDecimal amountOfByn1,amountOfByn2,amountOfUsd1,amountOfUsd2,amountOfEur1,amountOfEur2,amountOfRub1,amountOfRub2;
    @FindBy(xpath = "//*[contains(@name, 'header-form:openWorkplaceBalanceDialogButton')]")
    private WebElement remainsOfValuesOpenPopUpField;
    @FindBy(xpath = "//span[contains(text(),'Отменить')]")
    private WebElement remainsOfValuesClosePopUpBtn;
    public void remainsValuesOpenPopUp() {
        remainsOfValuesOpenPopUpField.click();
        expectation.findIframe();
        WebElement element = driver.findElement(By.xpath("//div[@class='ui-dialog-content ui-widget-content ui-df-content']/iframe"));
        driver.switchTo().frame(element);
    }
    public void remainsValuesClosePopUp() {
        remainsOfValuesClosePopUpBtn.click();
        driver.switchTo().defaultContent();
        expectation.waitingMenuVisible();
    }
    public BigDecimal getAmountOfCurrency(int value){
        WebElement amountOfCurrencyField= driver.findElement(By.xpath("//tr[@data-ri='"+value+"']/td[@class='-text-right']/span[@class='-text-strong']"));
        BigDecimal amountOfCurrency = new BigDecimal(amountOfCurrencyField.getText().replaceAll("\\s+","").replace(",", "."));
        return amountOfCurrency;
    }
    public void fixRemains(){
        remainsValuesOpenPopUp();
        amountOfByn1=getAmountOfCurrency(0);
        amountOfUsd1=getAmountOfCurrency(1);
        amountOfEur1=getAmountOfCurrency(2);
        amountOfRub1=getAmountOfCurrency(3);
        remainsValuesClosePopUp();
    }
    public void compareRemains(){
        remainsValuesOpenPopUp();
        amountOfByn2=getAmountOfCurrency(0);
        amountOfUsd2=getAmountOfCurrency(1);
        amountOfEur2=getAmountOfCurrency(2);
        amountOfRub2=getAmountOfCurrency(3);
        Assert.assertEquals(amountOfByn1.add(BigDecimal.TEN), amountOfByn2);
        Assert.assertEquals(amountOfUsd1, amountOfUsd2);
        Assert.assertEquals(amountOfEur1, amountOfEur2);
        Assert.assertEquals(amountOfRub1, amountOfRub2);
        remainsValuesClosePopUp();
    }
}