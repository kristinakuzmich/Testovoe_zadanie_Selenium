package buttons;
import Expectations.Expectation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBaseClass;
public class Button extends PageBaseClass {
    Expectation expectation=new Expectation();
    @FindBy(xpath = "//button[@id='main-content-form:confirm']")
    private WebElement continueBtn;
    public void clickContinueBtn(){
        continueBtn.click();
        expectation.waitingLogoLoading();
    }
}
