public class Player {
    private String name;
    private Roles role;
    private boolean alive = true;
    private boolean attacked = false;
    private boolean defended = false;
    private boolean silenced = false;
    Game gameObj = new Game();


    public Player(String name){
        this.name = name;

    }

    public static void main(String[] args){

    }

    public String getName(){
        return(this.name);
    }

    private void setRole(Roles roleIn){
        this.role = roleIn;
    }

    private void attack(){
        this.attacked = true;
    }
    
    private void defend(){
        this.defended = true;
    }

    private void kill(){
        this.alive = false;
    }

    private void silence(){
        this.silenced = true;
    }
    private Player pick(){
        Player selectedPlayer = gameObj.playerPick();
        return (selectedPlayer);
    }




    private void switchNightAction(){
        switch (this.role) {
            case WEREWOLF:

                break;
        
            case BODYGUARD:
                Player selectedPlayer = gameObj.playerPick();
            default:
                break;
        }
    }

    private void nightActionWerewolf(){
        pick().attack();
    }

    private void nightActionBodyguard(){
        pick().defend();
    }

    private void nightActionVillager(){
    }

    private void nightActionSorcerer(){
        pick().silence();
    }

}
