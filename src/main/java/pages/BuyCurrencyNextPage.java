package pages;

import Expectations.Expectation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.math.BigDecimal;

public class BuyCurrencyNextPage extends PageBaseClass{
    Expectation expectation=new Expectation();
    @FindBy(xpath = "//input[@id='main-content-form:dataTableId:0:received_input']")
    private WebElement currencyField;
    @FindBy(xpath = "//button[@id='main-content-form:confirm']")
    private WebElement continueBtn;

    public void inputCurrencyField(BigDecimal amount){
        currencyField.click();
        expectation.waitingLogoLoading();
        currencyField.sendKeys(String.valueOf(amount));
        driver.findElement(By.tagName("h1")).click();
    }
    public void clickContinueBtn(){
        continueBtn.click();
        expectation.waitingLogoLoading();
    }

}
