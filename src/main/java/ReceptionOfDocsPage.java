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
    @FindBy(xpath = "//div[@class='fieldset-button fieldset-button--white']/a/span[@class='js-toogle']")
    private WebElement openBtn;
    @FindBy(xpath = "//label[@class='ui-outputlabel ui-widget']/following-sibling::input[@id='main-content-form:name']")
    private WebElement fioField;
    @FindBy(xpath = "//input[@id='main-content-form:personalData']/following-sibling::label[@class='ui-outputlabel ui-widget']")
    private WebElement docBtn;
    @FindBy(xpath = "//*[contains(@id, 'main-content-form:confirm')]")
    private WebElement continueBtn;
    @FindBy(xpath = "//label[@id='main-content-form:docType_label']")
    private WebElement docType;
    public void clickKindList() {
        kindField.click();
    }
    @FindBy(xpath = "//ul[@id='main-content-form:kind_items']")
    private WebElement kindList;
    public void find(String currency){
    WebElement locRequiredUserName = findKindList(kindList, currency);
    locRequiredUserName.click();
        expectation.waitingLogoLoading();
    }
    public WebElement findKindList (WebElement kindList, String substitutionValue ) {
        String xpath = "//li[contains(text(),'%s')]";
        return kindList.findElement(By.xpath(String.format(xpath, substitutionValue)));
    }
    public void inputAmount(BigDecimal amount) {
        amountField.click();
        amountField.sendKeys(String.valueOf(amount));
    }
    public void inputPurpose(String purpose) {
        purposeField.sendKeys(purpose);
    }
    public void inputDescription(String description) {
        descriptionField.sendKeys(description);
    }
    public void clickOpenBtn() {
        openBtn.click();
        expectation.waitingLogoLoading();
    }
    public void inputFio(String fio) {
        fioField.click();
        fioField.sendKeys(fio);
    }
    public void clickDocBtn() {
        docBtn.click();
        expectation.waitingLogoLoading();
    }
    public void clickContinueBtn() {
        continueBtn.click();
        expectation.waitingLogoLoading();
    }
    public String getdocTypeText() {
        return docType.getText();
    }
}