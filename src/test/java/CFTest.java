import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CFTest {
    public static CFLogin loginPage = new CFLogin();
    public static CFPage profilePage = new CFPage();

    @BeforeTest
    public static void setup() {
        SingletonDriver.getDriver().get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void loginTest() {
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        String user = profilePage.getUserName();
        Assert.assertEquals("Кузьмич М.И.", user);
        profilePage.entryMenu();
    }

    @AfterTest
    public void close(){
        SingletonDriver.closeDriver();
    }
}