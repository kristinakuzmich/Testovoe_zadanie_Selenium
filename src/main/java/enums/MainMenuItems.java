package enums;

public enum MainMenuItems {
    PRIEMPODOCUMENTAM("Прием по документам"),
    BOOK("Книга учета принятых и выданных ценностей");
    private String message;
    MainMenuItems(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}