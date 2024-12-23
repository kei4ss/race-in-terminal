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

    static final String MENUTEXT = """
            .___  ___.  _______ .__   __.  __    __\s
            |   \\/   | |   ____||  \\ |  | |  |  |  |
            |  \\  /  | |  |__   |   \\|  | |  |  |  |
            |  |\\/|  | |   __|  |  . `  | |  |  |  |
            |  |  |  | |  |____ |  |\\   | |  `--'  |
            |__|  |__| |_______||__| \\__|  \\______/\s""";

    public static void menu(){
        int userOption;
        String linhaDecoracao = "-".repeat(40);

        limparTela.clean();
        System.out.println(util.colorText(linhaDecoracao, "yellow"));
        System.out.println(util.colorText(MENUTEXT, "cyan"));
        System.out.println(util.colorText(linhaDecoracao, "yellow"));

        System.out.println(" ");

        System.out.println("[1] - Começar partida");
        System.out.println("[2] - Ver placar");
        System.out.println("[3] - Gerenciar carros");
        System.out.println("[4] - Sair ");

        System.out.print("-> ");
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
                System.out.println("abrir gerenciador de carros");
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
        System.out.println("""
                 ____  _                            _     \s
                |  _ \\| | __ _  ___ __ _ _ __    __| | ___\s
                | |_) | |/ _` |/ __/ _` | '__|  / _` |/ _ \\
                |  __/| | (_| | (_| (_| | |    | (_| |  __/
                |_|   |_|\\__,_|\\___\\__,_|_|     \\__,_|\\___|
                __   _(_) |_ /_/  _ __(_) __ _ ___        \s
                \\ \\ / / | __/ _ \\| '__| |/ _` / __|       \s
                 \\ V /| | || (_) | |  | | (_| \\__ \\       \s
                  \\_/ |_|\\__\\___/|_|  |_|\\__,_|___/ \s
                """);

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
        System.out.println("Aperte ENTER para voltar ao menu.");
        leia.nextLine(); leia.nextLine();
        menu();
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

}
