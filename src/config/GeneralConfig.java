package config;

import java.io.IOException;

public class GeneralConfig {

    public static void limparTela(){
        String nomeSistema = System.getProperty("os.name");
        if(nomeSistema.contains("Windows")){
            try{
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }catch(IOException | InterruptedException e){
                for(int i=0; i<20; i++){System.out.println("\n\n\n");}
            }
        }
        else{
            for(int i=0; i<20; i++){System.out.println("\n\n\n");}
        }
    }

    public static void criarMenu(String[] opcoes){
        System.out.println(" ");
        for(int i = 1; i <= opcoes.length; i++){
            System.out.printf("[%d] - %s \n", i, opcoes[i-1]);
        }
        System.out.print("-> ");
    }

    public static void pause(int temp){
        try {
            Thread.sleep(temp * 1000L);
        } catch (InterruptedException e) {
            System.out.println("A pausa foi interrompida!");
        }
    }

}
