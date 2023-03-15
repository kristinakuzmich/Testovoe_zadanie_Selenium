import org.testng.Assert;
import org.testng.annotations.*;
public class ReceptionOfDocsTest extends AuthorizationTest{
    public static MainMenuPage menuPage = new MainMenuPage();
    public static ReceptionOfDocsPage docsPage = new ReceptionOfDocsPage();
    public static IssuanceAcceptionPage acceptPage = new IssuanceAcceptionPage();
    @Test(dataProvider="testdata",dataProviderClass=ReceptionOfDocsTestData.class)
    public void test(String searchText,
                     String currency,
                     int amount,
                     String purpose,
                     String description,
                     String fio,
                     String textNessage){
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
        Assert.assertEquals(textNessage, message);
    }
}