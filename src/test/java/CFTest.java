import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class CFTest {
    public static CFLogin loginPage;
    public static CFPage profilePage;
    public static WebDriver driver;
    @BeforeClass
    public static void setup() {
        SingletonDriver sd= SingletonDriver.getInstanceOfSingletonDriver();
        WebDriver driver = sd.getDriver();
        loginPage = new CFLogin(driver);
        profilePage = new CFPage(driver);
        driver.get("http://192.168.166.198:8080/fos/"); }
    @Test
    public void loginTest() {
        loginPage.inputLogin("bnbkass36");
        loginPage.inputPasswd("cash_bnb");
        loginPage.clickLoginBtn();
        String user = profilePage.getUserName();
        String name= "Кузьмич М.И.";
        Assert.assertEquals(name, user); }
    @AfterClass
    public static void tearDown() {

        profilePage.entryMenu();
        }
}
