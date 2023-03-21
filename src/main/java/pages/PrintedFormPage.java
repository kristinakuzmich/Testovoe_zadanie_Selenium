package pages;
import To.ValuesTo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class PrintedFormPage extends PageBaseClass{
    @FindBy(xpath = "//div[@id='main-content-form:panelWrap_content']/div/pre")
    private WebElement printFormField;
    public void isTextInPrintForm(ValuesTo to){
        String str= printFormField.getText();
        Pattern pattern = Pattern.compile("Сумма операции[ ]{2,}"+to.getCurrency().getCode()+"[ ]{2,}"+to.getAmount().setScale(2)+"");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find())
            System.out.println(str.substring(matcher.start(), matcher.end()));
    }
}
