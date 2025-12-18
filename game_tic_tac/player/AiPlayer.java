package game_tic_tac.player;

// import game_tic_tac.player.Player;
import game_tic_tac.board.Board;
import game_tic_tac.enums.Symbole;
import java.util.Scanner;

public class AiPlayer implements Player  {

    private Symbole symbole;
    private int row;
    private int col;
    private String name;
    private Scanner scanner;

    public AiPlayer(Symbole symbole, String name) {
        this.symbole = symbole;
        this.name = name;
    }

    public void setSymbole(Symbole symbole) {
        this.symbole = symbole;
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
    public int getRow() {
        return this.row;
    }
    @Override
    public int getCol() {
        return this.col;
    }
    @Override
    public int[] makeMove(Board board) {

        return new int[]{row, col};
    }

}
