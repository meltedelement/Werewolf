import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.management.relation.Role;
public class Launcher {
    
    public ArrayList<Player> players;
    public Launcher(){
        Game.playersCreate(TakeInPlayers());

    }
    public static void main(String[] args) throws Exception {
        
    }

    private static String[] TakeInPlayers(){
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

public Map<Player, Roles> assignPlayersToRoles() {
        Map<Player, Roles> playerRoleMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        for (Roles role : Roles.values()) {
            System.out.println("Assign a player for the role: " + role.name());
            System.out.println("Available players:");
            
            for (int i = 0; i < players.size(); i++) {
                System.out.println(i + ": " + players.get(i).getName());
            }
            
            System.out.print("Enter player number to assign to " + role.name() + " or -1 to skip: ");
            int playerIndex = scanner.nextInt();

            if (playerIndex >= 0 && playerIndex < players.size()) {
                playerRoleMap.put(players.get(playerIndex), role);
                players.remove(playerIndex); // Remove assigned player to prevent duplicates
            }
        }

        scanner.close();
        return playerRoleMap;
    }
}







