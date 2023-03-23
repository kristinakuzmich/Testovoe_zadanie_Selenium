package pages;
import Expectations.Expectation;
import To.RemainsValuesTo;
import To.ValuesTo;
import enums.Currency;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class RemainsValuesPopup extends PageBaseClass {
    Expectation expectation = new Expectation();
    BigDecimal currentDec,currentUsd,currentByn,exch;
    @FindBy(xpath = "//*[contains(@name, 'header-form:openWorkplaceBalanceDialogButton')]")
    private WebElement remainsOfValuesOpenPopUpField;
    @FindBy(xpath = "//span[contains(text(),'Отменить')]")
    private WebElement remainsOfValuesClosePopUpBtn;
    @FindBy(xpath = "tbody[id^='valuesBalanceForm']")
    private WebElement tbody;
    public List<RemainsValuesTo> getRemains() {
        remainsValuesOpenPopUp();
        List<RemainsValuesTo> elements = new ArrayList<>();
        List<WebElement> rows = driver.findElements(By.xpath("//tbody[contains(@id, 'valuesBalanceForm')]/tr"));
        for (WebElement row : rows) {
            String td2 = row.findElements(By.tagName("td")).get(1).getText();
            String td5 = row.findElements(By.tagName("span")).get(1).getText().replaceAll("\\s+", "").replace(",", ".");
            elements.add(new RemainsValuesTo(Currency.getCurrency(td2), new BigDecimal(td5)));
        }
        remainsValuesClosePopUp();
        return elements;
    }
    public void compareRemains(ValuesTo to, List<RemainsValuesTo> listBefore) {
        List<RemainsValuesTo> actualList = getRemains();
        listBefore = addOrSubstract(to, listBefore);
        Assert.assertEquals(actualList, listBefore);
    }
    public Optional<RemainsValuesTo> containsCurrency(List<RemainsValuesTo> list, Currency currency) {
        return list.stream().filter(o -> o.getCurrency().equals(currency)).findFirst();
    }
    public List<RemainsValuesTo> addOrSubstract(ValuesTo to, List<RemainsValuesTo> listBefore) {
        currentDec = containsCurrency(listBefore, to.getCurrency()).get().getAmount();
        if (to.getTypeOfMovement().getFlag() == 0) {
            containsCurrency(listBefore, to.getCurrency()).get().setAmount(currentDec.subtract(to.getAmount()));
        } else {
            containsCurrency(listBefore, to.getCurrency()).get().setAmount(currentDec.add(to.getAmount()));
        }
        return listBefore;
    }
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
    //Метод для покупки валюты
    public void compareRemainsAfterBuyingCurrency(ValuesTo valUSD,ValuesTo valBYN, List<RemainsValuesTo> listBefore){
        List<RemainsValuesTo> actualList = getRemains();
        listBefore = changeRemains(valUSD,valBYN, listBefore);
        Assert.assertEquals(actualList, listBefore);
    }
    public List<RemainsValuesTo> changeRemains(ValuesTo valUSD,ValuesTo valBYN, List<RemainsValuesTo> listBefore){
        driver.findElement(By.xpath("//span[contains(text(),'Курсы валют')]")).click();
        expectation.waitingLogoLoading();
        exch= new BigDecimal(driver.findElement(By.xpath("//tbody[contains(@id, 'header-form:currency-rates-panel')]/tr[1]/td[2]")).getText().replace(",", "."));

        currentUsd = containsCurrency(listBefore, valUSD.getCurrency()).get().getAmount();
        if (valUSD.getTypeOfMovement().getFlag() == 0) {
            containsCurrency(listBefore, valUSD.getCurrency()).get().setAmount(currentUsd.subtract(valUSD.getAmount()));
        } else {
            containsCurrency(listBefore, valUSD.getCurrency()).get().setAmount(currentUsd.add(valUSD.getAmount()));
        }
        currentByn = containsCurrency(listBefore, valBYN.getCurrency()).get().getAmount();
        if (valBYN.getTypeOfMovement().getFlag() == 0) {
            containsCurrency(listBefore, valBYN.getCurrency()).get().setAmount(currentByn.subtract(valBYN.getAmount().multiply(exch).setScale(2)));
        } else {
            containsCurrency(listBefore, valBYN.getCurrency()).get().setAmount(currentByn.add(valBYN.getAmount().multiply(exch).setScale(2)));
        }
        return listBefore;
    }
}