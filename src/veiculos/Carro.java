package veiculos;

public class Carro extends Veiculo{

    public Carro(String nome){
        this.nome = nome;
    }

    @Override
    public void desenhar(){
        System.out.printf("""
                %s    ______
                %s __//_||_\\\\__
                %s|   _     _   |
                %s '-(_)---(_)--'
                """, " ".repeat(distancia), " ".repeat(distancia), " ".repeat(distancia), " ".repeat(distancia));
        System.out.print("-".repeat(70));
        System.out.printf("  %s  \n", nome);
    }

    @Override
    public void standby(){
        System.out.printf("""
                    ______
                 __//_||_\\\\__
                |   _     _   |         %s
                '-(_)---(_)--'
                """, nome);
    }


}
