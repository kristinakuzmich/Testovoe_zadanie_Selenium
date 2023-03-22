import To.RemainsValuesTo;
import To.ValuesTo;
import buttons.Button;
import org.testng.annotations.Test;
import pages.*;
import testdata.BuyCurrencyTestData;
import java.util.List;
import static enums.MainMenuItems.*;
public class BuyCurrencyForCashTest extends AuthorizationTest {
    public static BuyCurrencyPage buyCurrencyPage = new BuyCurrencyPage();
    public static BuyCurrencyExchangePage buyCurrencyExchangePage=new BuyCurrencyExchangePage();
    public static BuyCurrencyNextPage buyCurrencyNextPage=new BuyCurrencyNextPage();
    public static RemainsValuesPopup remainsValues = new RemainsValuesPopup();
    public static PrintedFormPage printedFormPage=new PrintedFormPage();
    public static Button button=new Button();
    @Test(dataProvider = "buyCurrencyTestData", dataProviderClass=BuyCurrencyTestData.class)
    public void buyCashTest(ValuesTo valUsd,ValuesTo valByn){
        List<RemainsValuesTo> listBefore= remainsValues.getRemains();
        menuPage.searchField(BUYCURRENCY.getMessage());
        buyCurrencyPage.clickBuyCurrencyForCashBtn();
        button.clickContinueBtn();
        buyCurrencyExchangePage.inputAmount(valUsd.getAmount());
        button.clickContinueBtn();
        buyCurrencyNextPage.inputCurrencyField(valUsd.getAmount());
        button.clickContinueBtn();
        printedFormPage.isAssertSumsAndExchangeRate(valUsd,valByn);
        remainsValues.compareRemainsAfterBuyingCurrency(valUsd,valByn,listBefore);
    }
}
