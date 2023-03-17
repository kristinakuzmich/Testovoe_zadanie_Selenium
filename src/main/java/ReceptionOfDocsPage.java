import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.math.BigDecimal;
public class ReceptionOfDocsPage extends PageBaseClass {
    Expectation expectation=new Expectation();
    @FindBy(xpath = "//label[@id='main-content-form:kind_label']")
    private WebElement kindField;
    @FindBy(xpath = "//input[@id='main-content-form:amount_input']")
    private WebElement amountField;
    @FindBy(xpath = "//*[contains(@id, 'main-content-form:purpose')]")
    private WebElement purposeField;
    @FindBy(xpath = "//*[contains(@id, 'main-content-form:description')]")
    private WebElement descriptionField;
    @FindBy(xpath = "//span[contains(text(),'Развернуть')]")
    private WebElement openBtn;
    @FindBy(xpath = "//label[@class='ui-outputlabel ui-widget']/following-sibling::input[@id='main-content-form:name']")
    private WebElement fioField;
    @FindBy(xpath = "//input[@id='main-content-form:personalData']/following-sibling::label[@class='ui-outputlabel ui-widget']")
    private WebElement docBtn;
    @FindBy(xpath = "//*[contains(@id, 'main-content-form:confirm')]")
    private WebElement continueBtn;
    @FindBy(xpath = "//ul[@id='main-content-form:kind_items']")
    private WebElement kindList;
    public void inputDataInReceptionOfDocs(String currency,BigDecimal amount,String purpose,String description,String fio) {
        kindField.click();
        WebElement requiredCurrency = findKindList(kindList, currency);
        requiredCurrency.click();
        expectation.waitingLogoLoading();
        amountField.click();
        amountField.sendKeys(String.valueOf(amount));
        purposeField.sendKeys(purpose);
        descriptionField.sendKeys(description);
        clickOpenBtn();
        fioField.click();
        fioField.sendKeys(fio);
        docBtn.click();
        expectation.waitingLogoLoading();
        clickContinueBtn();
    }
    public WebElement findKindList (WebElement kindList, String currency ) {
        String xpath = "//li[contains(text(),'%s')]";
        return kindList.findElement(By.xpath(String.format(xpath,currency)));
    }
    public void clickOpenBtn() {
        openBtn.click();
        expectation.waitingLogoLoading();
    }
    public void clickContinueBtn() {
        continueBtn.click();
        expectation.waitingLogoLoading();
    }
}