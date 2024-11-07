import java.util.ArrayList;
import java.util.Scanner;
public class Launcher {

    public ArrayList<Player> players;
    public Launcher(){
        Game.playersCreate(TakeInPlayers());

    }
    public static void main(String[] args) throws Exception {
        
    }

    private static String[] TakeInPlayers(){
        ArrayList<String> playerNames = new ArrayList<String>();
        Scanner scanner = new Scanner(System.in);        

        System.out.println("Enter player count");
        int playerCount = Integer.parseInt(scanner.nextLine());
        for(int x = 0; x < playerCount; x++ ){
            System.out.println("Enter player"+ x + "Name");
            playerNames.add(scanner.nextLine());
        }
        String[] playerNamesArray = playerNames.toArray(new String[0]);
        return(playerNamesArray);
    }



}



