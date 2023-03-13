import org.testng.Assert;
import org.testng.annotations.*;
public class ReceptionOfDocsTest extends AuthorizationTest{
    public static LoginPage loginPage = new LoginPage();
    public static MainMenuPage menuPage = new MainMenuPage();
    public static ReceptionOfDocsPage docsPage = new ReceptionOfDocsPage();
    public static AissuanceAcceptionPage acceptPage = new AissuanceAcceptionPage();
    @Test(dataProvider="testdata",dataProviderClass=ReceptionOfDocsTestData.class)
    public void test(String searchText,
                     int amount,
                     String purpose,
                     String description,
                     String fio,
                     String textNessage) throws InterruptedException {
        menuPage.searchField(searchText);
        Thread.sleep(2000);
        menuPage.clickDoc();
        Thread.sleep(4000);
        docsPage.clickElementList();
        docsPage.chooseKind();
        Thread.sleep(2000);
        docsPage.inputAmount(amount);
        docsPage.inputPurpose(purpose);
        docsPage.inputDescription(description);
        docsPage.clickOpenBtn();
        Thread.sleep(2000);
        docsPage.inputFio(fio);
        docsPage.clickDocBtn();
        docsPage.clickContinueBtn();
        Thread.sleep(3000);
        acceptPage.inputAmount(amount);
        acceptPage.clickContinueBtn();
        Thread.sleep(4000);
        String message = menuPage.getMessText();
        Assert.assertEquals(textNessage, message);
    }
}