package game_tic_tac.board;

import game_tic_tac.enums.Colors;
import game_tic_tac.enums.Symbole;
import game_tic_tac.utils.ColorText;

public class Board {

    public final int BOARD_SIZE = 3;
    private int emptyCellCount = BOARD_SIZE * BOARD_SIZE;
    public Cell cells[][];

    public Board() {
        this.cells = new Cell[BOARD_SIZE][BOARD_SIZE];
        this.clearBoard();

    }

    public boolean canPlayAt(int row, int col) {
        final boolean isOutOfRow = row < 1 || row > this.BOARD_SIZE;
        final boolean isOutOCol = col < 1 || col > this.BOARD_SIZE;

        if (isOutOfRow || isOutOCol) {
            final String message = isOutOfRow ? "ligne" : "colonne";
            System.out.println(ColorText.colorize("\tErreur : la valeur de la " + message + " doit être un nombre compris entre 1 et 3.", Colors.RED));
            return false;
        }
        boolean isCellEmpty = cells[row - 1][col - 1].isEmpty();
        if (!isCellEmpty) {
            System.out.println(ColorText.colorize("\tCette case est déjà occupée. Veuillez en choisir une autre.", Colors.YELLOW));
        }
        return isCellEmpty;
    }

    public void clearBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                Cell cell = cells[i][j];
                if (this.cells[i][j] == null) {
                    cells[i][j] = new Cell();
                } else {
                    this.cells[i][j].setvalue(Symbole.VIDE);
                }

                // if (i == 0 && j == 0) {
                //     System.out.println(cell == cells[i][j]);
                // }
            }
        }
    }

    public void printBoard() {
        System.out.println("");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("\t"+" ".repeat(5));
            for (int j = 0; j < BOARD_SIZE; j++) {
                String cellValue = String.valueOf(cells[i][j].getValue().getValue());
                String textColored = ColorText.colorize(cellValue, (i * BOARD_SIZE + j) % 2 == 1 ? Colors.RED : Colors.BLUE);
                System.out.print(textColored);
                if (j != BOARD_SIZE - 1) {
                    System.out.print(" | ");
                }
            }
            if (i != BOARD_SIZE - 1) {
                System.out.println("\n\t" + " ".repeat(3) + "-------------");
            }
        }
        System.err.println("\n");
    }

    public void playMove(Symbole symbole, int row, int col) {
        this.cells[row][col].setvalue(symbole);
    }

    public void markCellAsFilled() {
        this.emptyCellCount--;
    }

    public boolean hasAvailableCells() {
        return this.emptyCellCount > 0;
    }

    public static class Cell {

        private Symbole value;

        Cell() {
            this.value = Symbole.VIDE;
        }

        public void setvalue(Symbole value) {
            this.value = value;
        }

        public Symbole getValue() {
            return this.value;
        }

        public boolean isEmpty() {
            return this.value == Symbole.VIDE;
        }

    }
}
