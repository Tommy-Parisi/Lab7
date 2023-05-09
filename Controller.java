import java.util.ArrayList;

public class Controller {
    private Game game;
    private TextView text;

    public Game setUpGameModel(){
        // Create 4 pieces for team A
        // Load the pieces in an ArrayList
        ArrayList<Unit> piecesTeamA = new ArrayList<Unit>();

        BartSimpsonUnit bs = new BartSimpsonUnit();
        bs.setTeamColor("Blu");
        BartSimpsonUnit bart = new BartSimpsonUnit();
        bart.setTeamColor("Blu");

        TomJerryUnit tj = new TomJerryUnit();
        tj.setTeamColor("Blu");
        TomJerryUnit tom = new TomJerryUnit();
        tom.setTeamColor("Blu");

        piecesTeamA.add(bs);
        piecesTeamA.add(tj);
        piecesTeamA.add(bart);
        piecesTeamA.add(tom);

        // Create a team object
        Team teamA = new Team("Blu",piecesTeamA);
        Player playerOne = new Player(1, true, teamA);

        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Unit> piecesTeamB = new ArrayList<Unit>();

        BartSimpsonUnit bs2 = new BartSimpsonUnit();
        bs2.setTeamColor("Red");
        BartSimpsonUnit bart2 = new BartSimpsonUnit();
        bart2.setTeamColor("Red");

        TomJerryUnit tj2 = new TomJerryUnit();
        tj2.setTeamColor("Red");
        TomJerryUnit tom2 = new TomJerryUnit();
        tom2.setTeamColor("Red");

        piecesTeamB.add(bs2);
        piecesTeamB.add(tj2);
        piecesTeamB.add(bart2);
        piecesTeamB.add(tom2);

        // Create a team object
        Team teamB = new Team("Red",piecesTeamB);
        Player playerTwo = new Player(2, false, teamB);

        // Create an instance of the game
        return new Game(8, 8, playerOne, playerTwo);
    }

    public Controller(){
        this.game = setUpGameModel();
        this.text = new TextView();
        this.text.updateView(this.game);
    }

    public void carryOutAction(int fromRow, int fromCol, int toRow, int toCol, char action) {
        if (action == 'M') {
            ActionMove move = new ActionMove(this.game, fromRow, fromCol, toRow, toCol);
            move.performAction();
        }
        if (action == 'A') {
            ActionAttack attack = new ActionAttack(this.game, fromRow, fromCol, toRow, toCol);
            attack.performAction();
        }
        if (action == 'R') {
            ActionRecruit recruit = new ActionRecruit(this.game, fromRow, fromCol, toRow, toCol);
            recruit.performAction();
        }
        if (action == 'S') {
            ActionSpawn spawn = new ActionSpawn(this.game, fromRow, fromCol, toRow, toCol);
            spawn.performAction();
        }
    }
    public void playGame(){
        while (!(this.game.isGameEnded())){
            this.text.getNextPlayersAction(this.game);
            while (!(Rules.checkValidAction(this.game, this.text.getFromSquareRow(), this.text.getFromSquareCol(), this.text.getToSquareRow(), this.text.getToSquareCol(), this.text.getActionType()))){
                System.out.println("Not valid");
                this.text.getNextPlayersAction(this.game);
            }
            carryOutAction(this.text.getFromSquareRow(), this.text.getFromSquareCol(), this.text.getToSquareRow(), this.text.getToSquareCol(), this.text.getActionType());
            System.out.println(this.game);
        }
        System.out.println("Game over: " + this.game.getWinner() + " wins");
    }
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.playGame();
    }


}
