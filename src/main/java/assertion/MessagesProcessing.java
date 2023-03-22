package assertion;
import enums.Messages;
import org.testng.Assert;
import pages.MainMenuPage;
public class MessagesProcessing {
    public static MainMenuPage menuPage = new MainMenuPage();
    public void isAssertMessageOperationIsOver(){
        String message = menuPage.getMessText();
        Assert.assertEquals(Messages.OPERATIONISOVER.getMessage(), message);
    }
}
