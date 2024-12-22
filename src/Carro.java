import java.util.Random;

public class Carro {
    private int distancia = 0;
    private String nome;
    private Random gerador = new Random();
    private int vitorias;
    private final int VELOCIDADE = 5;


    public Carro(String nome){
        this.nome = nome;
    }

    public void desenhar(){
        System.out.printf("""
                %s    ______
                %s __//_||_\\\\__
                %s|   _     _   |    %s
                %s '-(_)---(_)--'
                """, " ".repeat(distancia), " ".repeat(distancia), " ".repeat(distancia), nome, " ".repeat(distancia));
        System.out.println("-".repeat(55));
    }

    public void standby(){
        System.out.printf("""
                    ______
                 __//_||_\\\\__
                |   _     _   |         %s
                '-(_)---(_)--'
                """, nome);
    }


    public void avancar(){
        distancia += gerador.nextInt(VELOCIDADE);
    }

    public int getDistancia(){
        return distancia;
    }

    public String getNome(){
        return nome;
    }

    public void reset(){
        distancia = 0;
    }

    public int getVitorias(){
        return vitorias;
    }

    public void incrementarVitorias(){
        vitorias++;
    }
    
}
