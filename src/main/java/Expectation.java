import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Expectation {
    WebDriver driver=SingletonDriver.getDriver();
    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    public void waitingLogoLoading(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ajaxStatusPanel']/div[@style='display: none;']")));
    }
    public void findIframe(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-dialog-content ui-widget-content ui-df-content']/iframe")));
    }
    public void waitingLoginFormVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("formLogin")));
    }
    public void waitingMenuText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Прием по документам')]")));
    }
    public void waitingMenuVisible(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='menu']")));
    }
}