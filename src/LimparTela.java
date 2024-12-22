import java.io.IOException;

class LimparTela{

    public void clean(){

        String namesystem = System.getProperty("os.name");
        if(namesystem.contains("Windows")){
            try{
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }catch(IOException | InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        else{
            for(int i=0; i<20; i++){System.out.println("\n\n\n");}
        }
    }
}