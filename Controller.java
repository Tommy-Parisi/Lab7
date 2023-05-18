import java.util.ArrayList;
import java.util.Collections;

public class Controller {
    private Game game;
    private TextView text;
    private GameEventLinkedList linkedList;

    public Game setUpGameModel(){
        // Create 4 pieces for team A
        // Load the pieces in an ArrayList
        ArrayList<Unit> piecesTeamA = new ArrayList<Unit>();

        BartSimpsonUnit bs = new BartSimpsonUnit();
        bs.setTeamColor("Blu");

        TomJerryUnit tj = new TomJerryUnit();
        tj.setTeamColor("Blu");

        StewieGriffinUnit g = new StewieGriffinUnit();
        g.setTeamColor("Blu");

        SquidwardUnit s = new SquidwardUnit();
        s.setTeamColor("Blu");

        piecesTeamA.add(bs);
        piecesTeamA.add(tj);
        piecesTeamA.add(g);
        piecesTeamA.add(s);

        // Create a team object
        Team teamA = new Team("Blu",piecesTeamA);
        Player playerOne = new Player(1, true, teamA);

        // Create 4 pieces for team B
        // Load the pieces in an ArrayList
        ArrayList<Unit> piecesTeamB = new ArrayList<Unit>();

        BartSimpsonUnit bs2 = new BartSimpsonUnit();
        bs2.setTeamColor("Red");

        TomJerryUnit tj2 = new TomJerryUnit();
        tj2.setTeamColor("Red");

        StewieGriffinUnit g2 = new StewieGriffinUnit();
        g2.setTeamColor("Red");

        SquidwardUnit s2 = new SquidwardUnit();
        s2.setTeamColor("Red");

        piecesTeamB.add(bs2);
        piecesTeamB.add(tj2);
        piecesTeamB.add(g2);
        piecesTeamB.add(s2);

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
        this.linkedList = new GameEventLinkedList();
    }

    public void carryOutAction(int fromRow, int fromCol, int toRow, int toCol, char action) {
        String actionString = "";
        String eventType = "";
        if (action == 'M') {
            ActionMove move = new ActionMove(fromRow, fromCol, toRow, toCol, this.game);
            move.performAction();
            actionString = move.toString();
            eventType = "M";
        }
        if (action == 'A') {
            ActionAttack attack = new ActionAttack(fromRow, fromCol, toRow, toCol, this.game);
            attack.performAction();
            actionString = attack.toString();
            eventType = "A";
        }
        if (action == 'R') {
            ActionRecruit recruit = new ActionRecruit(fromRow, fromCol, toRow, toCol, this.game);
            recruit.performAction();
            actionString = recruit.toString();
            eventType = "R";
        }
        if (action == 'S') {
            ActionSpawn spawn = new ActionSpawn(fromRow, fromCol, toRow, toCol, this.game);
            spawn.performAction();
            actionString = spawn.toString();
            eventType = "S";
        }
        GameEvent event = new GameEvent(this.game.getCurrentPlayer().getPlayerNumber(), eventType, actionString);
        GameEventNode eventNode = new GameEventNode(event);
        this.linkedList.push(eventNode);
    }

    public void playGame() {
        while (!(this.game.isGameEnded())) {
            text.getNextPlayersAction(this.game);
            while (!(Rules.checkValidAction(this.game, text.getFromSquareRow(), text.getFromSquareCol(), text.getToSquareRow(), text.getToSquareCol(), text.getActionType()))) {
                System.out.println("Not valid");
                text.getNextPlayersAction(this.game);
            }
            carryOutAction(text.getFromSquareRow(), text.getFromSquareCol(), text.getToSquareRow(), text.getToSquareCol(), text.getActionType());
            System.out.println(this.game);
        }
        // New addition
        System.out.println("Winning move: " + this.linkedList.pop().getEventDetails());
        ArrayList<GameEventLinkedList> gameEventLinkedLists = new ArrayList<>();
        gameEventLinkedLists.add(this.linkedList.pop("M"));
        gameEventLinkedLists.add(this.linkedList.pop("A"));
        gameEventLinkedLists.add(this.linkedList.pop("R"));
        gameEventLinkedLists.add(this.linkedList.pop("S"));
        Collections.sort(gameEventLinkedLists);
        Collection.reverse(gameEventLinkedLists);
        for (GameEventLinkedList eventList : gameEventLinkedLists) {
            System.out.println("Event Type: " + text.getActionType() + "Size: " + eventList.countEvents());
        }
        text.printEndOfGameMessage(this.game);
    }

    public static void main(String[] args) {
        Controller newController = new Controller();
        newController.playGame();
    }
}
