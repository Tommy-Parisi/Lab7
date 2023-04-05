import java.util.ArrayList;

/*
This class is the Player class for the lab
@author Thomas Parisi
@version 1.0
 */
public class Player{
    private int playerNumber;
    private boolean turn;
    private Team team;

    public Player(int playerNumber, boolean turn, Team team){
        this.playerNumber = playerNumber;
        this.turn = turn;
        this.team = team;
    }
    public Player(int playerNumber, Team team){
        this(playerNumber, true, team);
    }
    public Player(){
        this(1, new Team("", new ArrayList<Unit>()));
    }
    public int getPlayerNumber() {
        return playerNumber;
    }
    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }
    public boolean isTurn() {
        return this.turn;
    }
    public void setTurn(boolean turn) {
        this.turn = turn;
    }
    public Team getPlayersTeam() {
        return team;
    }
    public void setPlayersTeam(Team team) {
        this.team = team;
    }
}