package telas;

import config.GeneralConfig;
import veiculos.Veiculo;
import config.ColorConfig;

import java.util.List;
import java.util.Scanner;

public class Placar {

    static ColorConfig util = new ColorConfig();
    final static String PLACARTEXT = """
                 ____  _                            _     \s
                |  _ \\| | __ _  ___ __ _ _ __    __| | ___\s
                | |_) | |/ _` |/ __/ _` | '__|  / _` |/ _ \\
                |  __/| | (_| | (_| (_| | |    | (_| |  __/
                |_|   |_|\\__,_|\\___\\__,_|_|     \\__,_|\\___|
                __   _(_) |_ /_/  _ __(_) __ _ ___        \s
                \\ \\ / / | __/ _ \\| '__| |/ _` / __|       \s
                 \\ V /| | || (_) | |  | | (_| \\__ \\       \s
                  \\_/ |_|\\__\\___/|_|  |_|\\__,_|___/ \s
                """;

    public static void loadSccreen(Scanner leia, List<Veiculo> veiculosDaCorrida){
        GeneralConfig.limparTela();

        String linhaDecoracao = "-".repeat(45);

        System.out.println(util.backgroundColorText(linhaDecoracao, "blue", "gray"));
        System.out.println(util.colorText(PLACARTEXT, "yellow"));
        System.out.println(util.backgroundColorText(linhaDecoracao, "blue", "gray"));

        System.out.println(" ");

        veiculosDaCorrida.sort((p1, p2) -> Integer.compare(p2.getVitorias(), p1.getVitorias()));
        for(int i = 1; i <= veiculosDaCorrida.size(); i++){
            System.out.printf("%d° - %s [%d vitórias] \n", i, veiculosDaCorrida.get(i-1).getNome(), veiculosDaCorrida.get(i-1).getVitorias());
        }

        leia.nextLine();
        leia.nextLine();
    }
}
