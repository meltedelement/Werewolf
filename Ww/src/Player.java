public class Player {
    private String name;
    private Roles role;
    private boolean alive = true;
    private boolean attacked = false;
    private boolean defended = false;
    private boolean silenced = false;
    private boolean doused = false;

    public Game gameObj = new Game();


    public Player(String name){
        this.name = name;
    }

    public static void main(String[] args){
    }



    private void setRole(Roles roleIn){
        this.role = roleIn;
    }

    public String getName(){
        return(this.name);
    }

    public Roles getRole(){
        return this.role;
    }

    public boolean getAttacked(){
        return(attacked);
    }

    public boolean getDefended(){
        return(defended);
    }

    private void attack(){
        this.attacked = true;
    }
    
    private void defend(){
        this.defended = true;
    }

    public void kill(){
        this.alive = false;
    }

    private void silence(){
        this.silenced = true;
    }
    private void douse(){
        this.doused = true;
    }





    private void performNightAction(){
        
        // Performing
        // Selected
        Player performingPlayer = this;
        Player selectedPlayer = gameObj.playerPick();
        if (selectedPlayer.getRole() == Roles.ARSONIST){
            this.douse();
        }

        else if (selectedPlayer.getRole() == Roles.VETERAN){
            this.kill();
        }
        switch (this.role) {
            case WEREWOLF:
                nightActionWerewolf(selectedPlayer);
                break;
        
            case BODYGUARD:
                nightActionBodyguard(selectedPlayer);

            default:
                break;
        }
    }

    private void nightActionWerewolf(Player selectedPlayer){
        selectedPlayer.attack();
    }

    private void nightActionBodyguard(Player selectedPlayer){
        selectedPlayer.defend();
    }

    private void nightActionVillager(){
    }

    private void nightActionSorcerer(Player selectedPlayer){
        if (Game.currentKillWolf != Roles.SORCERER)
        selectedPlayer.silence();
    }

}
