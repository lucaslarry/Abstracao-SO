package so;

public enum ProcessPriority {
    LOW(0), MEDIUM(1), HIGH(2), MAX(2000);

    private int level;

    ProcessPriority(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
