import org.testng.annotations.*;
public class ReceptionOfDocsTest extends AuthorizationTest {
    public static MainMenuPage menuPage = new MainMenuPage();
    public static MessagesProcessing messagesProcessing = new MessagesProcessing();
    public static ReceptionOfDocsPage docsPage = new ReceptionOfDocsPage();
    public static IssuanceAcceptionPage acceptPage = new IssuanceAcceptionPage();
    public static RemainsValuesPopup remainsValues = new RemainsValuesPopup();
    BookOfValuesPage bookOfValuesPage =new BookOfValuesPage();
    @Test(dataProvider = "testdata", dataProviderClass = ReceptionOfDocsTestData.class)
    public void test(DocTo doc,
                     BookOfValuesTo exp,
                     ValuesTo val) {
        remainsValues.fixRemains();
        menuPage.searchField(MainMenuItems.PRIEMPODOCUMENTAM.getMessage());
        docsPage.inputDataInReceptionOfDocs(val.getCurrency().getCurrency(),val.getAmount(),doc.getPurpose(),doc.getDescription(),doc.getUserName());
        acceptPage.inputAmount(val.getAmount());
        messagesProcessing.isAssertMessageOperationIsOver();
        remainsValues.compareRemains();
        menuPage.searchField(MainMenuItems.BOOK.getMessage());
        bookOfValuesPage.search();
        bookOfValuesPage.check(exp);
    }
}