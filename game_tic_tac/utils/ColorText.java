package game_tic_tac.utils;

import  game_tic_tac.enums.Colors;

public class ColorText {

    private static ColorText instance;

    private ColorText() {
        System.out.println("im Color Texte");
    }

    public static ColorText getInstance() {
        if (instance == null) {
            instance = new ColorText();
        }
        return instance;
    }

    public static  String colorize(String message, Colors color) {
        return color.getValue() + message + Colors.RESET.getValue();
    }
    public static String removeColorCodes(String str){
        return str.replaceAll("\u001B\\[[;\\d]*m", "");
    }
}
