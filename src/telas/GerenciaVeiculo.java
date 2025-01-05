package telas;

import java.util.Scanner;

import enfeites.Utilidades;

public class GerenciaVeiculo {

    static Utilidades util = new Utilidades();

    public static void loadScreen(Scanner leia){
        util.clean();
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
        util.criarMenu(opcoes);
        userOption = leia.nextInt();

        switch (userOption){
            case 1:
                break;
            case 5:
                break;
            default:
                break;
        }

        leia.nextLine();
        leia.nextLine();
    }
}
