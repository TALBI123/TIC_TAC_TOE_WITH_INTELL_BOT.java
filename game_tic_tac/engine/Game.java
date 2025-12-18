package game_tic_tac.engine;

import game_tic_tac.board.Board;
import game_tic_tac.enums.GameMode;
import game_tic_tac.enums.Symbole;
import game_tic_tac.player.Player;

public class Game {

    private Board board;
    private GameMenu gameMenu;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private GameMode mode;

    public Game() {
        gameMenu = new GameMenu();
        board = new Board();
    }

    public void setupGame() {
        gameMenu.displayWelcome();
        mode = gameMenu.getGameMode();
        player1 = gameMenu.createPlayer(gameMenu.chooseSymbol());
        Symbole nextPlayerSymbole = this.getOpponentSymbol(player1.getSymbole());
        // System.out.println("Symbole : " + nextPlayerSymbole);

        switch (mode) {
            case GameMode.PLAYER_VS_PLAYER:
                player2 = gameMenu.createPlayer(nextPlayerSymbole);
                break;
            case GameMode.PLAYER_VS_AI:
                player2 = gameMenu.createAiPlayer(nextPlayerSymbole);
                break;
        }
        currentPlayer = player1;
        do {
            currentPlayer.makeMove(board);
            System.out.println("Player move : " + currentPlayer.getSymbole().getValue());
            switchPlayer();
            board.printBoard();

        } while (board.hasAvailableCells());

    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private Symbole getOpponentSymbol(Symbole symbole) {
        return symbole == Symbole.X ? Symbole.O : Symbole.X;
    }
}
