public class ActionMove extends Action {
    public ActionMove(Game game, int fromRow, int fromColumn, int toRow, int toColumn) {
        super(game, fromRow, fromColumn, toRow, toColumn);
    }

    public void performAction() {
        BoardSquare[][] square = this.game.getBoardSquares();
        Unit unit = square[fromRow][fromColumn].removeUnit();
        square[toRow][toColumn].setUnit(unit);
        this.game.changeTurn();
    }

}
