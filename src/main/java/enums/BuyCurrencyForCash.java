package enums;
public enum BuyCurrencyForCash {
    BUYCURRENCYFORCASH("Покупка наличной валюты за наличные рубли"),
    BUYCURRENCYFORNONCASH("Покупка наличной валюты за безналичные рубли");
    public String message;
    BuyCurrencyForCash(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}