package enfeites;

import java.util.Arrays;

public class Utilidades {

    private final String RESET = "\u001B[0m";
    private final String BLACK = "\u001B[30m";
    private final String RED = "\u001B[31m";
    private final String GREEN = "\u001B[32m";
    private final String YELLOW = "\u001B[33m";
    private final String BLUE = "\u001B[34m";
    private final String PURPLE = "\u001B[35m";
    private final String CYAN = "\u001B[36m";
    private final String WHITE = "\u001B[37m";
    private final String GRAY = "\u001B[90m";

    private final String BLACK_BACKGROUND = "\u001B[40m";
    private final String RED_BACKGROUND = "\u001B[41m";
    private final String GREEN_BACKGROUND = "\u001B[42m";
    private final String YELLOW_BACKGROUND = "\u001B[43m";
    private final String BLUE_BACKGROUND = "\u001B[44m";
    private final String PURPLE_BACKGROUND = "\u001B[45m";
    private final String CYAN_BACKGROUND = "\u001B[46m";
    private final String WHITE_BACKGROUND = "\u001B[47m";
    private final String GRAY_BACKGROUND = "\u001B[100m";

    private final String[] ENDERECAMENTO = {"BLACK", "RED", "GREEN", "YELLOW", "BLUE", "PURPLE", "CYAN", "WHITE", "GRAY"};
    private final String[] ALLTEXTCOLOR = {BLACK, RED, GREEN, YELLOW, BLUE, PURPLE, CYAN, WHITE, GRAY};
    private final String[] ALLBACKGROUNDCOlOR = {BLACK_BACKGROUND, RED_BACKGROUND, GREEN_BACKGROUND, YELLOW_BACKGROUND, BLUE_BACKGROUND, PURPLE_BACKGROUND, CYAN_BACKGROUND, WHITE_BACKGROUND, GRAY_BACKGROUND};


    public Utilidades(){}

    public String colorText(String text, String color){
        int index = procurarCor(color);
        if(index!= -1){
            return ALLTEXTCOLOR[index] + text + RESET;
        }
        return text;
    }

    public String backgroundColorText(String text, String textColor, String colorBackground){
        int index = procurarCor(colorBackground);
        if(index!= -1){
            return ALLBACKGROUNDCOlOR[index] + colorText(text, textColor) + RESET;
        }
        return text;
    }

    private int procurarCor(String color){
        String userColor = color.toUpperCase();
        boolean corVaida = Arrays.asList(ENDERECAMENTO).contains(userColor);
        if(corVaida){
            return Arrays.asList(ENDERECAMENTO).indexOf(userColor);
        }
        return -1;
    }
}
