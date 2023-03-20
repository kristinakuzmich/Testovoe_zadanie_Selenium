import org.testng.annotations.DataProvider;
import java.math.BigDecimal;
public class ReceptionOfDocsTestData {
    @DataProvider(name="testdata")
    public Object[][]dataSet(){
        DocTo doc=new DocTo("Оплата по Договору","Платеж физического лица за приобретаемое",ConfProperties.getProperty("userName"));
        BookOfValuesTo exp=new BookOfValuesTo(MainMenuItems.PRIEMPODOCUMENTAM.getMessage(),ConfProperties.getProperty("userName"), Currency.CURRENCYBYN.getCurrency(),BigDecimal.TEN);
        ValuesTo val=new ValuesTo(Currency.CURRENCYBYN, MoveType.RECEIVE,BigDecimal.TEN);
        return new Object[][]{{doc,exp,val}};
    }
}