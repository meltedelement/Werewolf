import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.management.relation.Role;

public class Launcher {



    
    public Launcher(){
        assignRolesToPlayers();
    }
    public static void main(String[] args) throws Exception {
        Game gameObj = new Game();
        gameObj.gameStart();
        
    }

    public ArrayList<Player> playersCreate(String[] arrayIn){    //Turn an array of players into player objects using their names
        ArrayList<Player> players = new ArrayList<Player>();
        for (String x : arrayIn){
            players.add(new Player(x));
        }
        return(players);
    }

    private String[] TakeInPlayers(){
        Scanner scanner = new Scanner(System.in);        

        ArrayList<String> playerNames = new ArrayList<String>();

        System.out.println("Enter player count");
        int playerCount = Integer.parseInt(scanner.nextLine());
        for(int x = 0; x < playerCount; x++ ){
            System.out.println("Enter player"+ x + "Name");
            playerNames.add(scanner.nextLine());
        }
        String[] playerNamesArray = playerNames.toArray(new String[0]);
        return(playerNamesArray);
    }

public void assignRolesToPlayers() {
        Scanner scanner = new Scanner(System.in);
        for (Player x : playersCreate(TakeInPlayers())){
            System.out.println(x);
            int count = 1;
            for (Roles y : Roles.values()){
                System.out.println(y);
                System.out.println(count);
                count++;
            }
            x.setRole(Roles.values()[scanner.nextInt()]);
        }
        scanner.close();
    }


}







