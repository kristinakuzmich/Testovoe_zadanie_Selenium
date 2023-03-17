import org.testng.annotations.DataProvider;
import java.math.BigDecimal;
public class ReceptionOfDocsTestData {
    static String userName="Кузьмич Максим Игоревич";
    static String currency="Белорусский рубль";
    static BigDecimal amount= BigDecimal.valueOf(100);
    @DataProvider(name="testdata")
    public Object[][]dataSet(){
        BookOfValuesTo exp=new BookOfValuesTo(MainMenuItems.PRIEMPODOCUMENTAM.getMessage(),userName,currency,amount);
        return new Object[][]
                {{currency,amount,"Оплата по Договору","Платеж физического лица за приобретаемое",userName,exp}};
    }
}