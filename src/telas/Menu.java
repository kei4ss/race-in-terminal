package telas;

import enfeites.Utilidades;
import veiculos.Veiculo;

import java.util.List;
import java.util.Scanner;

public class Menu {
    static Utilidades util = new Utilidades();

    static final String MENUTEXT = """
            .___  ___.  _______ .__   __.  __    __\s
            |   \\/   | |   ____||  \\ |  | |  |  |  |
            |  \\  /  | |  |__   |   \\|  | |  |  |  |
            |  |\\/|  | |   __|  |  . `  | |  |  |  |
            |  |  |  | |  |____ |  |\\   | |  `--'  |
            |__|  |__| |_______||__| \\__|  \\______/\s""";

    public static  void menu(Scanner leia, List<Veiculo> veiculosDaCorrida){
        int userOption;

        util.clean();

        // CRIAÇÃO DO CABEÇALHO
        String linhaDecoracao = "-".repeat(40);
        System.out.println(util.colorText(linhaDecoracao, "yellow"));
        System.out.println(util.colorText(MENUTEXT, "cyan"));
        System.out.println(util.colorText(linhaDecoracao, "yellow"));

        String[] opcoes = {"Começar partida", "Ver placar", "Gerenciar carros", "sair"};
        util.criarMenu(opcoes);
        userOption = leia.nextInt();

        switch (userOption) {
            case 1:
                Corrida.runGame(leia, veiculosDaCorrida);
                menu(leia, veiculosDaCorrida);
                break;

            case 2:
                Placar.loadSccreen(leia, veiculosDaCorrida);
                menu(leia, veiculosDaCorrida);
                break;

            case 3:
                GerenciaVeiculo.loadScreen(leia);
                menu(leia, veiculosDaCorrida);
                break;

            case 4:
                leia.close();
                System.out.println("Até a próxima!");
                System.exit(0);
                break;

            default:
                System.out.println("Opção não listada");
                menu(leia, veiculosDaCorrida);
                break;
        }
    }
}
