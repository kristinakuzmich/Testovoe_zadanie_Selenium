import To.ValuesTo;
import org.testng.annotations.Test;
import pages.*;
import testdata.BuyCurrencyTestData;
import static enums.MainMenuItems.*;
public class BuyCurrencyForCashTest extends AuthorizationTest {
    public static BuyCurrencyPage buyCurrencyPage = new BuyCurrencyPage();
    public static BuyCurrencyExchangePage buyCurrencyExchangePage=new BuyCurrencyExchangePage();
    public static BuyCurrencyNextPage buyCurrencyNextPage=new BuyCurrencyNextPage();
    public static PrintedFormPage printedFormPage=new PrintedFormPage();
    @Test(dataProvider = "buyCurrencyTestData", dataProviderClass=BuyCurrencyTestData.class)
    public void buyCashTest(ValuesTo to){
        menuPage.searchField(BUYCURRENCY.getMessage());
        buyCurrencyPage.clickBuyCurrencyForCashBtn();
        buyCurrencyPage.clickContinueBtn();
        buyCurrencyExchangePage.inputAmount(to.getAmount());
        buyCurrencyExchangePage.clickContinueBtn();
        buyCurrencyNextPage.inputCurrencyField(to.getAmount());
        buyCurrencyNextPage.clickContinueBtn();
        printedFormPage.isTextInPrintForm(to);
    }
}
