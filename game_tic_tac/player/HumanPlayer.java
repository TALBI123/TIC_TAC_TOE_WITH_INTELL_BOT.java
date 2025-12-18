package game_tic_tac.player;

import game_tic_tac.board.Board;  // Ajoutez game_tic_tac.
import game_tic_tac.enums.Symbole;    // Ajoutez game_tic_tac.
import java.util.Scanner;

public class HumanPlayer implements Player {

    private Symbole symbole;
    private int row;
    private int col;
    private String name;
    private Scanner scanner;

    public HumanPlayer(Symbole symbol, String name) {
        this.symbole = symbol;
        this.name = name;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public Symbole getSymbole() {
        return this.symbole;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setSymbol(Symbole symbole) {
        this.symbole = symbole;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    @Override
    public int[] makeMove(Board board) {
        // System.out.println("\t Turn  qdqsds "+this.symbole.getValue()+" :");
        do {
            System.out.print("\tEnter a row (1-3): ");
            row = this.scanner.nextInt();

            System.out.print("\tEnter a col (1-3): ");
            col = this.scanner.nextInt();
        } while (!board.canPlayAt(row, col));
        board.playMove(this.symbole, row - 1, col - 1);
        // board.cells[row - 1][col - 1].setvalue(Symbole.X);
        return new int[]{row, col};
    }

}
