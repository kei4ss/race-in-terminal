package veiculos;

import java.util.Random;
import config.ColorConfig;

public class Veiculo {
    protected int distancia = 0;
    protected String nome;
    protected Random gerador = new Random();
    protected int vitorias;
    protected final int VELOCIDADE = 5;
    private ColorConfig util = new ColorConfig();

    public void desenhar(){};

    public void standby(){};

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

    protected void desenhePista(){
        String seguimento = util.colorText("-", "white") + util.colorText("-", "gray");
        System.out.print(seguimento.repeat(32));
    }

}
