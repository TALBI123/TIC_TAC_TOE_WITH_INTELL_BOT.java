package game_tic_tac.engine;

import game_tic_tac.enums.Colors;
import game_tic_tac.enums.GameMode;
import game_tic_tac.enums.Symbole;
import game_tic_tac.player.AiPlayer;
import game_tic_tac.player.HumanPlayer;
import game_tic_tac.utils.ColorText;
import java.util.Scanner;

public class GameMenu {

    private Scanner scanner;

    public GameMenu() {
        this.scanner = new Scanner(System.in);
    }

    public void displayWelcome() {
        System.out.println(ColorText.colorize("      ========== TIC TAC TOE ========== ", Colors.BLUE));
        System.out.println(ColorText.colorize("\tBienvenue!", Colors.GREEN));
    }

    public GameMode getGameMode() {
        System.out.println("\n\tChoisissez le mode de jeu:");
        String choices[] = {
            "|   1. " + ColorText.colorize("1. Joueur vs Joueur", Colors.BLUE),
            "|   2. " + ColorText.colorize("2. Joueur vs IA", Colors.YELLOW)};
        this.showSymbolMenu(choices, 35);
        
        System.out.print("\tVotre choix (1-2): ");
        int choice;
        boolean isFailed = Boolean.FALSE;
        do {
            choice = scanner.nextInt();
            isFailed = choice < 1 || choice > 2; // CORRECTION: < 1 au lieu de < 0
            if (isFailed) {
                System.out.println(ColorText.colorize("\n⚠️ Entrée invalide ! Veuillez saisir 1 pour Joueur vs Joueur ou 2 pour Joueur vs IA.\n", Colors.RED));
                System.out.print("\tVotre choix (1-2): ");
            }
        } while (isFailed);
        return choice == 1 ? GameMode.PLAYER_VS_PLAYER : GameMode.PLAYER_VS_AI;
    }

    public Symbole chooseSymbol() {
        boolean isFailed = Boolean.FALSE;
        int menuWidth = 15;
        int choice;
        String choices[] = {
            "|   1. " + ColorText.colorize("X", Colors.RED),
            "|   2. " + ColorText.colorize("O", Colors.GREEN)};

        System.out.println("\tChoisissez votre symbole:");
        this.showSymbolMenu(choices, menuWidth);
        System.out.print("\tVotre choix (1-2): ");
        do {
            choice = scanner.nextInt();
            scanner.nextLine();
            isFailed = choice < 1 || choice > 2; // CORRECTION: < 1 au lieu de < 0
            if (isFailed) {
                System.out.println(ColorText.colorize("\tVeuillez saisir 1 pour X ou 2 pour O", Colors.RED)); // CORRECTION du message
                System.out.print("\tVotre choix (1-2): ");
            }
        } while (isFailed);
        return choice == 1 ? Symbole.X : Symbole.O;
    }

    public HumanPlayer createPlayer(Symbole symbol) {
        System.out.print("\tEntrez votre nom : "); // CORRECTION: "Entrez" au lieu de "Enter voter"
        String name = scanner.nextLine();
        return new HumanPlayer(symbol, name);
    }
    
    public AiPlayer createAiPlayer(Symbole symbole){
        return new AiPlayer(symbole, "IA");
    }
    
    void showSymbolMenu(String[] choices, int menuWidth) {
        String padding = "\t";
        System.out.println(padding + "-".repeat(menuWidth));
        for (String choiceMessage : choices) {
            int visibleLength = ColorText.removeColorCodes(padding + choiceMessage).length();
            int paddingLength = menuWidth - visibleLength;
            System.out.println(padding + choiceMessage + " ".repeat(paddingLength) + "|");
        }
        System.out.println(padding + "-".repeat(menuWidth));
    }
}
