import org.testng.Assert;
import org.testng.annotations.*;
public class ReceptionOfDocsTest extends AuthorizationTest {
    public static MainMenuPage menuPage = new MainMenuPage();
    public static ReceptionOfDocsPage docsPage = new ReceptionOfDocsPage();
    public static IssuanceAcceptionPage acceptPage = new IssuanceAcceptionPage();
    public static RemainsValuesPopup remainsValues = new RemainsValuesPopup();
    @Test(dataProvider = "testdata", dataProviderClass = ReceptionOfDocsTestData.class)
    public void test(String searchText,
                     String currency,
                     int amount,
                     String purpose,
                     String description,
                     String fio) {
        remainsValues.remainsValuesClick();
        int amountByn1= remainsValues.getByn();
        remainsValues.cancelBtnClick();
        menuPage.searchField(searchText);
        menuPage.clickDoc();
        docsPage.clickKindList();
        docsPage.find(currency);
        docsPage.inputAmount(amount);
        docsPage.inputPurpose(purpose);
        docsPage.inputDescription(description);
        docsPage.clickOpenBtn();
        docsPage.inputFio(fio);
        docsPage.clickDocBtn();
        docsPage.clickContinueBtn();
        acceptPage.inputAmount(amount);
        acceptPage.clickContinueBtn();
        String message = menuPage.getMessText();
        Assert.assertEquals(Messages.OPERATIONISOVER.getMessage(), message);
        remainsValues.remainsValuesClick();
        int amountByn2= remainsValues.getByn();
        Assert.assertEquals(amountByn1 + amount, amountByn2);
        remainsValues.cancelBtnClick();
    }
}