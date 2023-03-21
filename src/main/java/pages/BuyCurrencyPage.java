package pages;

import Expectations.Expectation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuyCurrencyPage extends PageBaseClass{
    Expectation expectation=new Expectation();
    @FindBy(xpath = "//span[contains(text(),'Покупка наличной валюты за наличные рубли')]") // TODO занести в enum
    private WebElement buyCurrencyForCashBtn;
    @FindBy(xpath = "//button[@id='main-content-form:confirm']")
    private WebElement continueBtn;

    public void clickBuyCurrencyForCashBtn(){
        buyCurrencyForCashBtn.click();
        expectation.waitingLogoLoading();
    }

    public void clickContinueBtn(){
        continueBtn.click();
        expectation.waitingLogoLoading();
    }

}
