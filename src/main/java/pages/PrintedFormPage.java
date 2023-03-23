package pages;
import Expectations.Expectation;
import To.ValuesTo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.codeborne.selenide.Condition;
import java.math.BigDecimal;
import static com.codeborne.selenide.Selenide.$;
public class PrintedFormPage extends PageBaseClass{
    Expectation expectation=new Expectation();
    @FindBy(xpath = "//div[@id='main-content-form:panelWrap_content']/div/pre")
    private WebElement printFormField;
    public void isAssertSumsAndExchangeRate(ValuesTo valUSD,ValuesTo valBYN){
        $(printFormField).shouldHave(Condition.matchText("Сумма операции[ ]{2,}"+valUSD.getCurrency().getCode()+"[ ]{2,}"+valUSD.getAmount().setScale(2)+""));
        driver.findElement(By.xpath("//span[contains(text(),'Курсы валют')]")).click();
        expectation.waitingLogoLoading();
        BigDecimal exch= new BigDecimal(driver.findElement(By.xpath("//tbody[contains(@id, 'header-form:currency-rates-panel')]/tr[1]/td[2]")).getText().replace(",", "."));
        $(printFormField).shouldHave(Condition.matchText("Курс операции[ ]{2,}1[ ]{2,}"+valUSD.getCurrency().getCode()+"[ ]{2,}"+exch+""));
        $(printFormField).shouldHave(Condition.matchText("Сумма по курсу операции[ ]{2,}"+valBYN.getCurrency().getCode()+"[ ]{2,}"+valBYN.getAmount().multiply(exch).setScale(2)+""));
    }
}
