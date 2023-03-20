package factory;

import To.BookOfValuesTo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.math.BigDecimal;
public class BookOfValuesFactory{
public static BookOfValuesTo creator(WebElement webElement){
    return BookOfValuesTo.builder()
            .operation(webElement.findElements(By.tagName("td")).get(3).getText())
            .fio(webElement.findElements(By.tagName("td")).get(4).getText())
            .currency(webElement.findElements(By.tagName("td")).get(8).getText())
            .amount(new BigDecimal((webElement.findElements(By.tagName("td")).get(9).getText()).replaceAll("\\s+","").replace(",", ".")))
            .build();
    }
}
