import enfeites.Utilidades;
import veiculos.Carro;
import veiculos.Motocicleta;
import veiculos.Train;
import veiculos.Veiculo;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static List<Veiculo> veiculosDaCorrida = new ArrayList<>();
    static LimparTela limparTela = new LimparTela();
    static Scanner leia = new Scanner(System.in);
    static Utilidades util = new Utilidades();

    public static void menu(){
        int userOption;
        limparTela.clean();

        String linhaDecoracao = "-".repeat(40);
        final String MENUTEXT = """
            .___  ___.  _______ .__   __.  __    __\s
            |   \\/   | |   ____||  \\ |  | |  |  |  |
            |  \\  /  | |  |__   |   \\|  | |  |  |  |
            |  |\\/|  | |   __|  |  . `  | |  |  |  |
            |  |  |  | |  |____ |  |\\   | |  `--'  |
            |__|  |__| |_______||__| \\__|  \\______/\s""";

        System.out.println(util.colorText(linhaDecoracao, "yellow"));
        System.out.println(util.colorText(MENUTEXT, "cyan"));
        System.out.println(util.colorText(linhaDecoracao, "yellow"));

        String[] opcoes = {"Começar partida", "Ver placar", "Gerenciar carros", "sair"};
        criarMenu(opcoes);
        userOption = leia.nextInt();

        switch (userOption) {
            case 1:
                runGame();
                menu();
                break;
        
            case 2:
                showPlacar();
                menu();
                break;
            
            case 3:
                gerenciarVeiculo();
                menu();
                break;
            
            case 4:
                leia.close();
                System.out.println("Até a próxima!");
                System.exit(0);
                break;

            default:
                System.out.println("Opção não listada");
                menu();
                break;
        }
    }


    public static void showPlacar(){
        limparTela.clean();

        String linhaDecoracao = "-".repeat(45);
        final String PLACARTEXT = """
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

        System.out.println(util.backgroundColorText(linhaDecoracao, "blue", "gray"));
        System.out.println(util.colorText(PLACARTEXT, "yellow"));
        System.out.println(util.backgroundColorText(linhaDecoracao, "blue", "gray"));

        System.out.println(" ");

        veiculosDaCorrida.sort((p1, p2) -> Integer.compare(p2.getVitorias(), p1.getVitorias()));
        for(int i = 1; i <= veiculosDaCorrida.size(); i++){
            System.out.printf("%d° - %s [%d vitórias] \n", i, veiculosDaCorrida.get(i-1).getNome(), veiculosDaCorrida.get(i-1).getVitorias());
        }

        leia.nextLine(); leia.nextLine();
    }


    public static void runGame(){

        // mostra o frame inicial e garante que todos os carros tenham sua posição igual a 0
        // essa garantia é feita pela função .reset()
        limparTela.clean();
        for(Veiculo car : veiculosDaCorrida){
            car.reset();
            car.desenhar();
        }

        // Desenha a corrida e avança os carros
        for(int i = 0; i< 15; i++){
            pause(1);
            limparTela.clean();
            for(Veiculo car : veiculosDaCorrida){
                car.avancar();
                car.desenhar();
            }
        }

        // Determina o(s) carro(s) que percorreu(ram) a maior distância.
        // Para isso, percorremos a lista de carros e comparamos a distância de cada um:
        // - Se o carro atual percorreu uma distância maior que a maior registrada até agora (ultimaPontuacao),
        //   atualizamos a maior distância e limpamos a lista de vencedores para incluir apenas esse carro.
        // - Se a distância do carro atual for igual à maior registrada, adicionamos o carro à lista de vencedores.
        List<Veiculo> vencedor = new ArrayList<>();
        int ultimaPontuacao = 0;
        for(Veiculo car : veiculosDaCorrida){
            if(ultimaPontuacao < car.getDistancia()){
                ultimaPontuacao = car.getDistancia();
                vencedor.clear();
                vencedor.add(car);
            } else if(ultimaPontuacao == car.getDistancia()){
                vencedor.add(car);
            }
        }

        // Aumenta a quantidade de vítorias registradas para os carros que venceram a corrida.
        for (Veiculo carro : vencedor){
            carro.incrementarVitorias();
        }

        // Exibe o(s) vencedor(es) da corrida
        System.out.println("\n");
        String mensagem = vencedor.size() > 1 ? "OS VENCEDORES SÃO" : "O VENCEDOR É";
        System.out.printf(" ~~~~ %s: ", mensagem);
        for (Veiculo c : vencedor){
            System.out.printf("%s ", c.getNome());
        }
        System.out.println(" ~~~~ \n\n");

        // Mostra quantos metros cada carro fez
        System.out.println(" " + "_".repeat(10));
        System.out.println("|");
        for(Veiculo car : veiculosDaCorrida){
            System.out.printf("| %s : %d metros \n", car.getNome(), car.getDistancia());
        }
        System.out.print("|");
        System.out.println("_".repeat(10));

        // Espera pela interação do usuário para poder voltar ao menu
        System.out.println("\nAperte ENTER para voltar ao menu.");
        leia.nextLine(); leia.nextLine();
    }


    public static void pause(int temp){
        try {
            Thread.sleep(temp * 1000L);
        } catch (InterruptedException e) {
            System.out.println("A pausa foi interrompida!");
        }
    }


    public static void standbyCars(){

        for(Veiculo car : veiculosDaCorrida){
            car.standby();
            System.out.println("/".repeat(20));
        }
    }


    public static void main(String[] args) {

        veiculosDaCorrida.add(new Carro("Relampago Marquinhos"));
        veiculosDaCorrida.add(new Carro("Amilton Sena"));
        veiculosDaCorrida.add(new Motocicleta("Motoqueiro fantasma"));
        veiculosDaCorrida.add(new Train("esse tren"));

        menu();
    }


    public static void gerenciarVeiculo(){
        limparTela.clean();
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
        criarMenu(opcoes);
        userOption = leia.nextInt();

        switch (userOption){
            case 1:
                break;
            case 5:
                menu();
                break;
            default:
                gerenciarVeiculo();
                break;
        }

        leia.nextLine(); leia.nextLine();
    }

    public static void criarMenu(String[] opcoes){
        System.out.println(" ");

        for(int i = 1; i <= opcoes.length; i++){
            System.out.printf("[%d] - %s \n", i, opcoes[i-1]);
        }

        System.out.print("-> ");
    }

}
