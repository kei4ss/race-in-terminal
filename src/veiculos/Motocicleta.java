package veiculos;

public class Motocicleta extends Veiculo{

    public Motocicleta(String nome){
        this.nome = nome;
    }

    @Override
    public void desenhar(){
        System.out.printf("""
                %s         ,'
                %s      ::.,-c\\-.
                %s      (_)=='(_)
                """, " ".repeat(distancia), " ".repeat(distancia), " ".repeat(distancia));
        desenhePista();
        System.out.printf("  %s  \n", nome);
    }

    @Override
    public void standby(){
        System.out.printf("""
                         ,'
                      ::.,-c\\-.
                      (_)=='(_)  %s
                """, nome);
    }
}
