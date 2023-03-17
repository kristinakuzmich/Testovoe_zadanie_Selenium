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
}