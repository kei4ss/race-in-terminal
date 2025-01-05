package telas;

import veiculos.Veiculo;
import enfeites.Utilidades;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Corrida {

    static Utilidades util = new Utilidades();

    public static void runGame (Scanner leia, List<Veiculo> veiculosDaCorrida){

        // mostra o frame inicial e garante que todos os carros tenham sua posição igual a 0
        // essa garantia é feita pela função .reset()
        util.clean();
        for(Veiculo car : veiculosDaCorrida){
            car.reset();
            car.desenhar();
        }

        // Desenha a corrida e avança os carros
        for(int i = 0; i< 15; i++){
            util.pause(1);
            util.clean();
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
}
