import java.util.Collections;

/**
 * This class creates a Game
 * @Author Tommy Parisi & Joey Dare
 * @Version 1.0
 */
public class Game{
    private GameBoard gameBoard;
    private Player player1;
    private Player player2;

    public Game(int numRows, int numColumns, Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        initializeGameBoard(numRows, numColumns);


    }
    private GameBoard initializeGameBoard(int numRows, int numColumns){
        this.gameBoard = new GameBoard(numRows, numColumns);
        //insert code for the following algorithm:
        /**
         * Create an instance of GameBoard with the specified number of rows and columns.
         * For each unit in both player's teams:
         * a. Use the findRandomEmptySpace method in the GameBoard class to get a random empty space on the board.
         * b. Set the unit's coordinates to the coordinates of the empty space.
         * c. Place the unit on the board at the chosen coordinates.
         * Return the completed GameBoard.
         */
        for (Unit unit : player1.getTeam().getTeamUnits()) {
            BoardSquare randomSquare = gameBoard.findRandomEmptySpace();
            randomSquare.setUnit(unit);
        }
        for (Unit unit : player2.getTeam().getTeamUnits()) {
            BoardSquare randomSquare = gameBoard.findRandomEmptySpace();
            randomSquare.setUnit(unit);
        }

        BoardSquare specialSquare = gameBoard.findRandomEmptySpace(); //initializes special square
        specialSquare.setSpecial(specialSquare); //makes specialSquare special

        return gameBoard;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }
    public Player getCurrentPlayer() {
        if(player1.isTurn()){
            return player1;
        }
        else{
            return player2;
        }
    }
    public Player getOpponentPlayer() {
        if(player1.isTurn()){
            return player2;
        }
        else{
            return player1;
        }
    }

    public boolean isTurn(Player player) {
        return player.isTurn();
    }
    public BoardSquare[][] getBoardSquares() {
        return getGameBoard().getSquares();
    }

    /**
     * This mutator method changes both players turn status
     * from its current status to the opposite
     */
    public void changeTurn() {
        player1.setTurn(!isTurn(player1));
        player2.setTurn(!isTurn(player2));
    }

    public boolean isAWinner(){
        return (player1.getTeam().getTeamUnits().size() == 0) ^ (player2.getTeam().getTeamUnits().size() == 0);
    }

    public Player getWinner() {
        if (player1.getTeam().getTeamUnits().size() == 0) {
            return player2;
        } else if (player2.getTeam().getTeamUnits().size() == 0) {
            return player1;
        } else {
            return null;
        }
    }

    public boolean isGameEnded(){
        return (player1.getTeam().getTeamUnits().size() == 0) || (player2.getTeam().getTeamUnits().size() == 0);
    }

    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game Board:\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\n" + getGameBoard().toString())
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\n" + getCurrentPlayer().getTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\n" + getOpponentPlayer().getTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(10 + gameBoard.getNumColumns()*8, "*")))
                .append("\nIt is Player " + getCurrentPlayer().getPlayerNumber() + "'s (" + getCurrentPlayer().getTeam().getTeamColor() + "'s) turn\n");
        return retString.toString();
    }

}