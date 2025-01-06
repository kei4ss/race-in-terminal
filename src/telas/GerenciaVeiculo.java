package telas;

import java.util.Scanner;

import config.ColorConfig;
import config.GeneralConfig;

public class GerenciaVeiculo {

    static ColorConfig util = new ColorConfig();

    public static void loadScreen(Scanner leia){
        GeneralConfig.limparTela();
        int userOption;

        String linhaDecoracao = "/".repeat(80);
        final String GERENVEICULOTEXT = """
                ____    ____  _______  __    ______  __    __   __        ______        _______.
                \\   \\  /   / |   ____||  |  /      ||  |  |  | |  |      /  __  \\      /       |
                 \\   \\/   /  |  |__   |  | |  ,----'|  |  |  | |  |     |  |  |  |    |   (----`
                  \\      /   |   __|  |  | |  |     |  |  |  | |  |     |  |  |  |     \\   \\   \s
                   \\    /    |  |____ |  | |  `----.|  `--'  | |  `----.|  `--'  | .----)   |  \s
                    \\__/     |_______||__|  \\______| \\______/  |_______| \\______/  |_______/   \s""";

        System.out.println(util.backgroundColorText(linhaDecoracao, "gray", "purple"));
        System.out.println(util.backgroundColorText(GERENVEICULOTEXT, "white", "black"));
        System.out.println(util.backgroundColorText(linhaDecoracao, "gray", "purple"));

        String[] opcoes = {"Adicionar novo veiculo", "remover veiculo", "renomear veiculo", "alterar o tipo de veículo", "voltar ao menu"};
        GeneralConfig.criarMenu(opcoes);
        userOption = leia.nextInt();

        switch (userOption){
            case 1:
                break;
            case 5:
                break;
            default:
                break;
        }
    }
}
