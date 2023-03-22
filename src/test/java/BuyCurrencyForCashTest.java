import To.RemainsValuesTo;
import To.ValuesTo;
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
    @Test(dataProvider = "buyCurrencyTestData", dataProviderClass=BuyCurrencyTestData.class)
    public void buyCashTest(ValuesTo valUsd,ValuesTo valByn){
        List<RemainsValuesTo> listBefore= remainsValues.getRemains();
        menuPage.searchField(BUYCURRENCY.getMessage());
        buyCurrencyPage.clickBuyCurrencyForCashBtn();
        buyCurrencyExchangePage.inputAmount(valUsd.getAmount());
        buyCurrencyNextPage.inputCurrencyField(valUsd.getAmount());
        printedFormPage.isAssertSumsAndExchangeRate(valUsd,valByn);
        remainsValues.compareRemainsAfterBuyingCurrency(valUsd,valByn,listBefore);
    }
}
