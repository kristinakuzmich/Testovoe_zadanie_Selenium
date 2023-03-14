import org.testng.Assert;
import org.testng.annotations.*;
public class AuthorizationTest {
    public static LoginPage loginPage = new LoginPage();
    public static MainMenuPage menuPage = new MainMenuPage();
    @BeforeTest
    public static void openBrowser() {
        SingletonDriver.getDriver().get(ConfProperties.getProperty("loginpage"));
    }
    @BeforeMethod
    public static void openCF(){
        loginPage.inputLogin(ConfProperties.getProperty("login"));
        loginPage.inputPasswd(ConfProperties.getProperty("password"));
        loginPage.clickLoginBtn();
        String username = menuPage.getUserName();
        Assert.assertEquals(ConfProperties.getProperty("user"), username);
    }
    @AfterMethod
    public void closeCF() {
        menuPage.exitCF();
    }
    @AfterTest
    public void closeDriver() {
        SingletonDriver.closeDriver();
    }
}