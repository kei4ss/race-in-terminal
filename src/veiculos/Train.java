package veiculos;

public class Train extends Veiculo{

    public Train(String nome){
        this.nome = nome;
    }

    @Override
    public void desenhar(){
        System.out.printf("""
                %s   ____
                %s   |DD|____T_
                %s   |_ |_____|<
                %s     @-@-@-oo\\
                """, " ".repeat(distancia), " ".repeat(distancia), " ".repeat(distancia), " ".repeat(distancia));
        desenhePista();
        System.out.printf("  %s  \n", nome);
    }

    @Override
    public void standby(){
        System.out.printf("""
                   ____
                   |DD|____T_
                   |_ |_____|<   %s
                     @-@-@-oo\\
                """, nome);
    }
}
