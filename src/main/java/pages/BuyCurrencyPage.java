package pages;
import Expectations.Expectation;
import buttons.Button;
import enums.BuyCurrencyForCash;
import org.openqa.selenium.By;
public class BuyCurrencyPage extends PageBaseClass{
    Expectation expectation=new Expectation();
    Button button=new Button();
    public void clickBuyCurrencyForCashBtn(){
        driver.findElement(By.xpath("//span[contains(text(),'"+ BuyCurrencyForCash.BUYCURRENCYFORCASH.getMessage() +"')]")).click();
        expectation.waitingLogoLoading();
        button.clickContinueBtn();
    }
}
