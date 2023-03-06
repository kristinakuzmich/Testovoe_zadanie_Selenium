import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CFTest {
    public static CFLogin loginPage;
    public static CFPage profilePage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        SingletonDriver sd = SingletonDriver.getInstanceOfSingletonDriver();
        driver = sd.getDriver();
        loginPage = new CFLogin(driver);
        profilePage = new CFPage(driver);
        driver.get(ConfProperties.getProperty("loginpage"));
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
}