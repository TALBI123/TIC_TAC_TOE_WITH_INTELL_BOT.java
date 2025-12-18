package game_tic_tac.enums;

public enum Colors {

    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m"),
    RESET("\u001B[0m");

    private final String value;

    private Colors(String color) {
        this.value = color;
    }

    public String getValue() {
        return this.value;
    }
}
