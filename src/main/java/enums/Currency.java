package enums;
import org.testng.Assert;
import java.util.Arrays;
import java.util.NoSuchElementException;
public enum Currency {
    CURRENCYBYN("Белорусский рубль","BYN"),
    CURRENCYUSD("Доллар США","USD"),
    CURRENCYEUR("Евро","EUR"),
    CURRENCYRUB("Российский рубль","RUB");
    private String currency;
    private String code;
    Currency(String currency, String code) {
        this.currency = currency;
        this.code = code;
    }
    public String getCurrency() {
        return currency;
    }
    public String getCode() {
        return code;
    }
    public static Currency getCurrency(String name) {
        try{
            return Arrays.stream(Currency.values())
                    .filter(obj -> name.equals(obj.currency))
                    .findFirst().get();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Не найдена ценность по имени: " + name);
        }
        return null;
    }
}