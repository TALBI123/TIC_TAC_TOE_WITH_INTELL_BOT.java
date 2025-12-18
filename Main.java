import game_tic_tac.board.Board;
import game_tic_tac.engine.Game;
import game_tic_tac.engine.GameMenu;

class Mere {
    Mere(){
        System.out.println("mok");
    }
    public void display() {
        System.out.println("Inside Mere class");
    }
}

class Child extends Mere {

    // @Override
    public void display() {
        System.out.println("Inside Child class");
    }
}

public class Main {

    public static void main(String[] args) {
        
        GameMenu gameMenu = new GameMenu();
        Board board = new Board();
        Game game = new Game();
        game.setupGame();
        // game.switchPlayer();
        // board.printBoeard();
        // HumanPlayer human = new HumanPlayer(Symbole.X, "mohamed");
        // human.makeMove(board);
        // board.printBoeard();
    }
}
