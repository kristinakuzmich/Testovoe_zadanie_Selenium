package testdata;
import To.ValuesTo;
import enums.Currency;
import enums.MoveType;
import org.testng.annotations.DataProvider;
import java.math.BigDecimal;
public class BuyCurrencyTestData {
    @DataProvider(name="buyCurrencyTestData")
    public Object[][]dataSet(){
        ValuesTo valUsd=new ValuesTo(Currency.CURRENCYUSD, MoveType.RECEIVE,BigDecimal.TEN);
        ValuesTo valByn=new ValuesTo(Currency.CURRENCYBYN, MoveType.ISSUE,BigDecimal.TEN);
        return new Object[][]{{valUsd,valByn}};
    }
}
