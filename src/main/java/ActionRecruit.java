/**
This class contains the Action to recruit units
@author
Joey Dare
@version 1.0
*/
public class ActionRecruit extends Action{

public ActionRecruit(int fromRow, int fromCol, int toRow, int toCol, Game game) {
    super(fromRow, fromCol, toRow, toCol, game);
}

//Method to perform recruit
@Override
public void performAction() {
    BoardSquare[][] findUnit = this.game.getGameBoard().getSquares();
    Unit toUnit = findUnit[toRow][toCol].getUnit();
    // removes unit from the opponent's team
    this.game.getOpponentPlayer().getTeam().removeUnitsFromTeam(toUnit);
    // adds unit to the current team
    this.game.getCurrentPlayer().getTeam().addUnitsToTeam(toUnit);
    // change the turn
    this.game.changeTurn();
}

}
