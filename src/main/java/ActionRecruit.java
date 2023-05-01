public class ActionRecruit extends Action{

public ActionRecruit(int fromRow, int fromCol, int toRow, int toCol, Game game) {
    super(fromRow, fromCol, toRow, toCol, game);
}
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
