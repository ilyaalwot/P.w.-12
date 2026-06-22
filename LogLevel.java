public enum LogLevel {
    CRITICAL("[CRITICAL]"),
    ERROR("[ERROR]"),
    WARNING("[WARNING]"),
    INFO("[INFO]"),
    DEBUG("[DEBUG]");

    private final String label;

    LogLevel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
