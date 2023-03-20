package enums;

import org.testng.Assert;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum Currency {
    CURRENCYBYN("Белорусский рубль"),
    CURRENCYUSD("Доллар США"),
    CURRENCYEUR("Евро"),
    CURRENCYRUB("Российский рубль");
    private String currency;
    Currency(String currency) {
        this.currency = currency;
    }
    public String getCurrency() {
        return currency;
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