import To.BookOfValuesTo;
import To.DocTo;
import To.RemainsValuesTo;
import To.ValuesTo;
import assertion.MessagesProcessing;
import enums.MainMenuItems;
import org.testng.annotations.*;
import pages.*;
import testdata.ReceptionOfDocsTestData;
import java.util.List;
import static enums.MainMenuItems.*;
public class ReceptionOfDocsTest extends AuthorizationTest {
    public static MainMenuPage menuPage = new MainMenuPage();
    public static MessagesProcessing messagesProcessing = new MessagesProcessing();
    public static ReceptionOfDocsPage docsPage = new ReceptionOfDocsPage();
    public static IssuanceAcceptionPage acceptPage = new IssuanceAcceptionPage();
    public static RemainsValuesPopup remainsValues = new RemainsValuesPopup();
    BookOfValuesPage bookOfValuesPage =new BookOfValuesPage();
    @Test(dataProvider = "testdata", dataProviderClass = ReceptionOfDocsTestData.class)
    public void receptionOfDocsTest(DocTo doc,
                     BookOfValuesTo exp,
                     ValuesTo val) {
        List<RemainsValuesTo> listBefore=remainsValues.getRemains();
        menuPage.searchField(PRIEMPODOCUMENTAM.getMessage());
        docsPage.inputDataInReceptionOfDocs(val.getCurrency().getCurrency(),val.getAmount(),doc.getPurpose(),doc.getDescription(),doc.getUserName());
        acceptPage.inputAmount(val.getAmount());
        messagesProcessing.isAssertMessageOperationIsOver();
        remainsValues.compareRemains(val,listBefore);
        menuPage.searchField(MainMenuItems.BOOK.getMessage());
        bookOfValuesPage.search();
        bookOfValuesPage.check(exp);
    }
}