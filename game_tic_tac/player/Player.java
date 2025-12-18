package game_tic_tac.player;

import game_tic_tac.board.Board;
import game_tic_tac.enums.Symbole;

public interface Player {

    Symbole getSymbole();

    void setSymbol(Symbole symbol);

    int[] makeMove(Board board);

    String getName();

    int getRow();

    int getCol();

    // void setPosition();
}
