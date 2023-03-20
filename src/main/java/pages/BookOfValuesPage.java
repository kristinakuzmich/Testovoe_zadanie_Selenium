package pages;

import Expectations.Expectation;
import To.BookOfValuesTo;
import factory.BookOfValuesFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class BookOfValuesPage extends PageBaseClass {
    Expectation expectation=new Expectation();
    BookOfValuesFactory bookOfValuesFactory=new BookOfValuesFactory();
    @FindBy(xpath = "//label[@id='main-content-form:kindList_label']")
    private WebElement currencyField;
    @FindBy(xpath = "//label[@id='main-content-form:businessProcesses_label']")
    private WebElement operationField;
    @FindBy(xpath = "//span[contains(text(),'Поиск')]")
    private WebElement searchBtn;
    public void search(){
        searchBtn.click();
        expectation.waitingLogoLoading();
    }
    public WebElement getFirstLine(){
        WebElement line=driver.findElement(By.xpath("//tbody[@id='main-content-form:htable_data']/tr[1]"));
        return line;
    }
    public void check(BookOfValuesTo exp){
        BookOfValuesTo actual = BookOfValuesFactory.creator(getFirstLine());
        Assert.assertEquals(exp,actual);
    }
}