package enums;

public enum Messages {
    OPERATIONISOVER("Операция завершена");
    public String message;
    Messages(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}