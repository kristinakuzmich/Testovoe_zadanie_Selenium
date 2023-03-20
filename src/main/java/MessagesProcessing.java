import org.testng.Assert;

public class MessagesProcessing {
    public static MainMenuPage menuPage = new MainMenuPage();
    public void isAssertMessageOperationIsOver(){
        String message = menuPage.getMessText();
        Assert.assertEquals(Messages.OPERATIONISOVER.getMessage(), message);
    }
}
