public enum MoveType {
    ISSUE(0, "расход"),
    RECEIVE(1, "приход");
    private int flag;
    private String name;
    MoveType(int flag, String name) {
        this.flag = flag;
        this.name = name;
    }
    public int getFlag() {
        return flag;
    }

    public String getName() {
        return name;
    }
}