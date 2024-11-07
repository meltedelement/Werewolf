import java.util.ArrayList;
import java.util.Scanner;

public class Game{
    private int nightNum;
    private int aliveCount;
    private Roles currentKillWolf;
    Launcher newObj = new Launcher();

    public Roles getCurrentKillWolf(){
        return(currentKillWolf);
    }

    public Game(){
    }
    
  

    public Player playerPick(){  // A placeholder function to allow a player to be selected in command line until i have a frontend
        Scanner scan = new Scanner(System.in);
        for(Player x : newObj.players){
            System.out.println(newObj.players.indexOf(x));
            System.out.println(x.getName());
        }
        System.out.println("Enter the number of the selected player");
        return(newObj.players.get(Integer.valueOf(scan.nextLine())));   //Get the player object indicated by the index input by the user
    }

    public void processDeaths(){
        for(Player x : newObj.players){
            if (x.getAttacked() && ! x.getDefended()){
                x.kill();
            }
        }
    }

    public void gameStart(){
        boolean finish = false;
        while (finish != true){

        }
    }

    



}