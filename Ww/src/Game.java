import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;


public class Game{
    private int nightNum = 0;
    private int aliveCount;
    private Roles currentKillWolf;
    Launcher launcherObj = new Launcher();

    public enum GameStates{
    DAY,
    NIGHT,
    STARTING,
    FINISHED
    }

    public Roles getCurrentKillWolf(){
        return(currentKillWolf);
    }



    public Player playerPick(){  // A placeholder function to allow a player to be selected in command line until i have a frontend
        Scanner scan = new Scanner(System.in);
        for(Player x : launcherObj.players){
            if (x.getAlive()){
                System.out.println(launcherObj.players.indexOf(x));
                System.out.println(x.getName());
            }
        }
        System.out.println("Enter the number of the selected player");
        return(launcherObj.players.get(Integer.valueOf(scan.nextLine())));   //Get the player object indicated by the index input by the user
    }

    public void processDeaths(){
        for(Player x : launcherObj.players){
            if (x.getAttacked() && ! x.getDefended()){
                x.kill();
            }
        }
    }

    public void nightActions(){
        Roles[] nightOrder = {Roles.WEREWOLF, Roles.SORCERER, Roles.BODYGUARD, Roles.SEER, Roles.ARSONIST};
        for (Roles role : nightOrder){
            for(Player player : launcherObj.players){
                if (player.getRole() == role){
                    player.performNightAction();
                }
            }
        }
    }

    public void dayActions(){
        
    }


    public void gameStart(){
        GameStates gameState = GameStates.NIGHT;
        while (gameState != GameStates.FINISHED){
            switch (gameState) {
                case DAY:
                    dayActions();
                    gameState = GameStates.NIGHT;
                    break;
                
                case NIGHT:
                    nightActions();
                    nightNum += 1;
                    processDeaths();
                    gameState = GameStates.DAY;
                    break;
                default:
                    break;
            }
        }
    }

    



}