public class ActionMove extends Action {
    public ActionMove(int fromRow, int fromCol, int toRow, int toCol, Game game) {
        super(fromRow, fromCol, toRow, toCol, game);
    }

    public void performAction() {
        BoardSquare[][] square = this.game.getBoardSquares();
        Unit unit = square[fromRow][fromCol].removeUnit();
        square[toRow][toCol].setUnit(unit);
        this.game.changeTurn();
    }

}