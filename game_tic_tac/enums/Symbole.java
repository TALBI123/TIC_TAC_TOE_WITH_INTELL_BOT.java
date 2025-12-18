package game_tic_tac.enums;

public enum Symbole {
    X('X'),
    O('O'),
    VIDE(' '); // Pour représenter une case vide
    private final char value;

    Symbole(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
    
}
