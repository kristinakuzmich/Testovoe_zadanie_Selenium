import org.testng.Assert;
import org.testng.annotations.*;
import java.math.BigDecimal;
public class ReceptionOfDocsTest extends AuthorizationTest {
    public static MainMenuPage menuPage = new MainMenuPage();
    public static ReceptionOfDocsPage docsPage = new ReceptionOfDocsPage();
    public static IssuanceAcceptionPage acceptPage = new IssuanceAcceptionPage();
    public static RemainsValuesPopup remainsValues = new RemainsValuesPopup();
    BookOfValues bookOfValues=new BookOfValues();
    @Test(dataProvider = "testdata", dataProviderClass = ReceptionOfDocsTestData.class)
    public void test(String currency,
                     BigDecimal amount,
                     String purpose,
                     String description,
                     String fio,
                     BookOfValuesTo exp) {
        remainsValues.remainsValuesClick();
        BigDecimal amountByn1= remainsValues.getByn();
        remainsValues.cancelBtnClick();
        menuPage.searchField(MainMenuItems.PRIEMPODOCUMENTAM.getMessage());
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
        BigDecimal amountByn2= remainsValues.getByn();
        Assert.assertEquals(amountByn1.add(amount), amountByn2);
        remainsValues.cancelBtnClick();
        menuPage.cleanField();
        menuPage.searchField(MainMenuItems.BOOK.getMessage());
        bookOfValues.search();
        bookOfValues.check(exp);
    }
}