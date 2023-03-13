import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReceptionOfDocsPage extends PageBaseClass {
    @FindBy(xpath = "//label[@id='main-content-form:kind_label']")
    private WebElement kindField;
    @FindBy(xpath = "//li[@id='main-content-form:kind_1']")
    private WebElement selectElementKind;
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
    public void clickElementList() {
        kindField.click();
    }
    public void chooseKind() {
        selectElementKind.click();
    }
    public void inputAmount(Integer amount) {
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
    }
    public void inputFio(String fio) {
        fioField.click();
        fioField.sendKeys(fio);
    }
    public void clickDocBtn() {
        docBtn.click();
    }
    public void clickContinueBtn() {
        continueBtn.click();
    }

}