import java.util.ArrayList;
import java.util.Collections;

public class Game {
    private GameBoard board;
    private Player player1;
    private Player player2;

    private void initializeGameBoard(int numRows, int numCols) {
        board = new GameBoard(numRows, numCols);
        ArrayList<Unit> teamUnits = Team.getTeamUnits();

        for (int i = 0; i < teamUnits.size(); i++) {
            GameBoard testGameBoard = new GameBoard(numRows, numCols);
            BoardSquare emptySpace = testGameBoard.findRandomEmptySpace();
            emptySpace.setUnit(teamUnits.get(i));

        }
    }

    public Game(int numRows, int numCols, Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        initializeGameBoard(numRows, numCols);
    }

    public GameBoard getGameBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        if (player1.isTurn()) {
            return player1;
        }
        else {
            return player2;
        }
    }

    public Player getOpponentPlayer() {
        if (player1.isTurn()) {
            return player2;
        }
        else {
            return player1;
        }
    }

    public boolean isTurn(Player player) {
        if (player.isTurn()) {
            return true;
        }
        else {
            return false;
        }
    }

    public BoardSquare[][] getBoardSquares() {
        return this.getGameBoard().getSquares();
    }

    public void changeTurn() {
        player1.setTurn(player1.isTurn());
        player2.setTurn(player2.isTurn());
    }

    public boolean isAWinner(){
        return (player1.getPlayersTeam().getTeamUnits().size() == 0) ^ (player2.getPlayersTeam().getTeamUnits().size() == 0);
    }

    public Player getWinner() {
        if (player1.getPlayersTeam().getTeamUnits().size() == 0) {
            return player2;
        } else if (player2.getPlayersTeam().getTeamUnits().size() == 0) {
            return player1;
        } else {
            return null;
        }
    }

    public boolean isGameEnded(){
        return (player1.getPlayersTeam().getTeamUnits().size() == 0) || (player2.getPlayersTeam().getTeamUnits().size() == 0);
    }

    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getBoardSquares().toString())
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getCurrentPlayer().getPlayersTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\n" + getOpponentPlayer().getPlayersTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + board.getNumColumns()*8, "*")))
                .append("\nIt is Player " + getCurrentPlayer().getPlayerNumber() + "'s (" + getCurrentPlayer().getPlayersTeam().getTeamColor() + "'s) turn\n");
        return retString.toString();
    }

}

