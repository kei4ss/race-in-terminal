import enfeites.Utilidades;
import veiculos.Carro;
import veiculos.Motocicleta;
import veiculos.Train;
import veiculos.Veiculo;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import telas.Menu;


public class Main {

    static List<Veiculo> veiculosDaCorrida = new ArrayList<>();
    static Scanner leia = new Scanner(System.in);
    static Utilidades util = new Utilidades();

    public static void main(String[] args) {

        veiculosDaCorrida.add(new Carro("Relampago Marquinhos"));
        veiculosDaCorrida.add(new Carro("Amilton Sena"));
        veiculosDaCorrida.add(new Motocicleta("Motoqueiro fantasma"));
        veiculosDaCorrida.add(new Train("esse tren"));

        Menu.menu(leia, veiculosDaCorrida);
    }

    /*
    public static void standbyCars(){

        for(Veiculo car : veiculosDaCorrida){
            car.standby();
            System.out.println("/".repeat(20));
        }
    }
     */

}
