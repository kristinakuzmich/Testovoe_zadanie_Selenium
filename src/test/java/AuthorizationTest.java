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
    public static void openCF() throws InterruptedException {
        Thread.sleep(3000);
        loginPage.inputLogin("bnbkass36");
        loginPage.inputPasswd("cash_bnb");
        loginPage.clickLoginBtn();
        Thread.sleep(2000);
        loginPage.clickOK();
        Thread.sleep(2000);
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