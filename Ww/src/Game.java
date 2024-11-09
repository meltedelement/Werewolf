import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;


public class Game{
    
    private int nightNum = 0;
    private int aliveCount;


    public enum GameStates{
    DAY,
    NIGHT,
    STARTING,
    FINISHED
    }

    public static void main(){
        Game Gaming = new Game();
        Gaming.gameStart();
    }


    public void getCurrentKillWolf(){
        Roles[] wolfKillPriority = {Roles.WEREWOLF, Roles.MISTWOLF, Roles.CUBWOLF, Roles.SORCERER};
        boolean wolfSelected = false;
        for (Roles x : wolfKillPriority){
            for (Player y : Launcher.players){
                if (y.getRole() == x && ! wolfSelected){
                    y.setKillWolf();
                }

            }
        }
    }
    


    public Player playerPick(){  // A placeholder function to allow a player to be selected in command line until i have a frontend
        Scanner scan = new Scanner(System.in);
        for(Player x : Launcher.players){
            if (x.getAlive()){
                System.out.println(Launcher.players.indexOf(x));
                System.out.println(x.getName());
            }
        }
        System.out.println("Enter the number of the selected player");
        return(Launcher.players.get(Integer.valueOf(scan.nextLine())));   //Get the player object indicated by the index input by the user
    }

    public void processDeaths(){
        for(Player x : Launcher.players){
            if (x.getAttacked() && ! x.getDefended()){
                x.kill();
            }
            if (!Arrays.asList(Player.basicDefenseRoles).contains(x.getRole())){
                x.unDefend();

            }
        }
    }

    public void nightActions(){
        
        Roles[] nightOrder = {Roles.WEREWOLF, Roles.SORCERER, Roles.BODYGUARD, Roles.SEER, Roles.ARSONIST};
        for (Roles role : nightOrder){
            for(Player player : Launcher.players){
                if (! player.skipVisit && player.getRole() == role){
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
                case NIGHT:
                nightActions();
                nightNum += 1;
                processDeaths();
                gameState = GameStates.DAY;
                break;

                case DAY:
                    dayActions();
                    gameState = GameStates.NIGHT;
                    break;
                

                default:
                    break;
            }
        }
    }

    



}