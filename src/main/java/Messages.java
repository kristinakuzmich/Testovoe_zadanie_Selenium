public enum Messages {
    OPERATIONISOVER("Операция завершена");
    private String message;

    Messages(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}